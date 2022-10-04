package xyz.leobellier.transaction.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xyz.leobellier.transaction.domain.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class TransactionRepositoryImpl {

    private final TransactionMapper mapper = new TransactionMapper();
    private final TransactionRepository repository;


    public List<Transaction> findAll() {
        List<TransactionEntity> entities = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(entities::add);

        return entities.stream().map(mapper::toTransaction).toList();
    }

    public List<Transaction> findAllById(String accountId) {
         return repository.findAllByAccountId(accountId).stream().map(mapper::toTransaction).toList();
    }

    public List<Transaction> findAllByIdAndDate(String accountId, LocalDate date) {
        return repository.findAllByAccountIdAndDate(accountId, date).stream().map(mapper::toTransaction).toList();
    }

    public TransactionEntity add(Transaction transaction, String account){
        return repository.save(mapper.toEntity(transaction, account));
    }

    public Transaction findById(String transactionId) {
        return repository.findById(transactionId).map(mapper::toTransaction).get();
    }
}
