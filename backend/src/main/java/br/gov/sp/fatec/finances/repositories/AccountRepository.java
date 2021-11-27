package br.gov.sp.fatec.finances.repositories;

import br.gov.sp.fatec.finances.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findTopByOrderByIdAsc();
    List<Account> findAccountByUser_Name(String userId);

}
