package xyz.leobellier.transaction.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.leobellier.transaction.domain.Transaction;
import xyz.leobellier.transaction.infrastructure.TransactionRepositoryImpl;

import java.time.LocalDate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionRepositoryImpl transactionRepository;

    Transaction transaction = new Transaction("",LocalDate.now(), "", "");

    String account = "";

    @Test
    public void shouldGiveAllTransactionsForAnAccountWhenReceiveAccountId() {
        assertThat(transactionService.getAllTransaction(account)).isEmpty();
    }

    @Test
    public void shouldGiveAllTransactionsForAnAccountInADayWhenReceiveAccountIdAndDate() {
        LocalDate date = LocalDate.of(2022, 1, 12);
        assertThat(transactionService.getTransactionsByDate(account, date)).isEmpty();
    }

    @Test
    public void shouldGiveATransactionsWhenReceiveATransactionId(){
        String transactionId = "";
        assertNotEquals(transaction, transactionService.findById(transactionId));
    }

    @Test
    public void shouldCreateANewTransactionWhenMakeANewTransactionAndAnAccountId() {
        assertFalse(transactionService.addNewTransaction(account, transaction));
    }

}