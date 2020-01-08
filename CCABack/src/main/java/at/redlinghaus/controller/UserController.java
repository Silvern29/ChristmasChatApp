package at.redlinghaus.controller;

import at.redlinghaus.dto.UserDTO;
import at.redlinghaus.entity.User;
import at.redlinghaus.exception.NoUserException;
import at.redlinghaus.exception.UserExistsException;
import at.redlinghaus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void login(String userName) throws UserExistsException {
        if (userExists(userName)) {
            User user = userRepository.findByUserName(userName);
            user.setLastLogin(LocalDateTime.now());
            update(user);
        } else {
            create(new UserDTO(userName));
        }
    }

    public User create(UserDTO accountDto) throws UserExistsException {
        if (userExists(accountDto.getUserName())) {
            throw new UserExistsException(
                    "Username already exists:" + accountDto.getUserName());
        }
        User user = new User();
        user.setUserName(accountDto.getUserName());
        user.setCreation(LocalDateTime.now());
        //Passwordencoder hashes the password using bcrypt
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//        user.setEmail(accountDto.getEmail());
        return userRepository.save(user);
    }

    private boolean userExists(final String userName) {
        return userRepository.findByUserName(userName) != null;
    }


    public User update(User user) {
        User optionalUser = userRepository.findByUserName(user.getUserName());
        if (userExists(user.getUserName())) {
            if (user.getUserName() != null) optionalUser.setUserName(user.getUserName());
            if (user.getEmail() != null) optionalUser.setEmail(user.getEmail());
            if (user.getPassword() != null) optionalUser.setPassword(passwordEncoder.encode(user.getPassword()));
            if (user.getLastLogin() != null) optionalUser.setLastLogin(user.getLastLogin());
            userRepository.save(optionalUser);
            return optionalUser;
        } else {
            throw new NoUserException("User not found");
        }
    }

    public User deleteById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User currentUser = optionalUser.get();
            userRepository.deleteById(id);
            return currentUser;
        } else {
            throw new NoUserException("User not found");
        }
    }
}