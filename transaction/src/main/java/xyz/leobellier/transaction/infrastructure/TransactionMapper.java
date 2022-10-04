package xyz.leobellier.transaction.infrastructure;

import xyz.leobellier.transaction.domain.Transaction;


public class TransactionMapper {

    public Transaction toTransaction(TransactionEntity transactionEntity) {
        return new Transaction(transactionEntity.getId(), transactionEntity.getDate(), transactionEntity.getPassword(), transactionEntity.getStatus());
    }

    public TransactionEntity toEntity(Transaction transaction, String account){
        return transaction.createEntity().accountId(account).build();
    }
}
