package hu.nje.cukraszda.auth;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
    // Bejelentkezés email alapján
    Optional<User> findByEmail(String email);
}
