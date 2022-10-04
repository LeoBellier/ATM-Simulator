package xyz.leobellier.transaction.domain;

import lombok.AllArgsConstructor;
import xyz.leobellier.transaction.infrastructure.TransactionEntity;

import java.time.LocalDate;

@AllArgsConstructor
public class Transaction {

    private String id;
    private LocalDate date;
    private String password;
    private String status;

    public TransactionEntity.TransactionEntityBuilder createEntity() {
        return TransactionEntity.builder().id(id)
                .password(password)
                .status(status)
                .date(date);
    }
}
