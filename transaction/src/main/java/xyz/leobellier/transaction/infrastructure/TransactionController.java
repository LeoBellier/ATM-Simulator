package xyz.leobellier.transaction.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.leobellier.transaction.application.TransactionService;

@RestController("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;
    private final TransactionMapper mapper = new TransactionMapper();

    @PostMapping("/add")
    public ResponseEntity newTransaction(@RequestParam String accountId, @RequestParam TransactionEntity transaction) {
        boolean wasAdded = service.addNewTransaction(accountId, mapper.toTransaction(transaction));
        return new ResponseEntity(HttpStatusCode.valueOf(wasAdded ? 200 : 400));
    }
}
