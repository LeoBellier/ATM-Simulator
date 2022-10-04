package xyz.leobellier.transaction.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class TransactionEntity {
    private String id;
    private String accountId;
    private LocalDate date;
    private String password;
    private String status;

}
