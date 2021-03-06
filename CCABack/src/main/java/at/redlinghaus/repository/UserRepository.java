package at.redlinghaus.repository;

import at.redlinghaus.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);

    Optional<User> findById(int id);

    @Query(value = "SELECT * FROM user where last_name LIKE %:lastName%", nativeQuery = true)
    Iterable<User> findUserByLastName(@Param("lastName") String lastName);

    User findByEmail(@Param("email") String email);

    LinkedList<User> findByOrderByIdAsc();
}
