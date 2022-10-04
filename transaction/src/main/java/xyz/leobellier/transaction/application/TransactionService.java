package xyz.leobellier.transaction.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.leobellier.transaction.domain.Transaction;
import xyz.leobellier.transaction.infrastructure.TransactionRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepositoryImpl repository;

    public List<Transaction> getAllTransaction(String account) {
        return repository.findAllById(account);
    }

    public List<Transaction> getTransactionsByDate(String account, LocalDate date) {
        return repository.findAllByIdAndDate(account, date);
    }

    public boolean addNewTransaction(String account, Transaction transaction) {
        return repository.add(transaction, account) != null;
    }

    public Transaction findById(String transactionId) {
        return repository.findById(transactionId);
    }
}
