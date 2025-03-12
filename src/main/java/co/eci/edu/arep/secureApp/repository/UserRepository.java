package co.eci.edu.arep.secureApp.repository;

import co.eci.edu.arep.secureApp.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Object findAll(Specification<User> spec);

    boolean existsByUsername(String username);
}
