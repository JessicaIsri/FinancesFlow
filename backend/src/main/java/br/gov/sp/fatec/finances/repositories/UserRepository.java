package br.gov.sp.fatec.finances.repositories;

import br.gov.sp.fatec.finances.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findTopByOrderByIdAsc();
    User findTop1ByNameOrEmail(String username, String email);
    Optional<User> findByEmailAndName(String email, String name);
}
