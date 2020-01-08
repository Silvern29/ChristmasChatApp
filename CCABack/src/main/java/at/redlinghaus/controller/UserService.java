package at.redlinghaus.controller;

import at.redlinghaus.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
