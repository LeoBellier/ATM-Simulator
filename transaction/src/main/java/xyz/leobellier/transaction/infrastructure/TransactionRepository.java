package xyz.leobellier.transaction.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    List<TransactionEntity> findAllByAccountId(String accountId);
    List<TransactionEntity> findAllByAccountIdAndDate(String accountId, LocalDate date);
}
