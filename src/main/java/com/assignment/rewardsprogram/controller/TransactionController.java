package com.assignment.rewardsprogram.controller;

import com.assignment.rewardsprogram.model.AddTransactionRequest;
import com.assignment.rewardsprogram.model.Transaction;
import com.assignment.rewardsprogram.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("transactions")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @GetMapping("/byUserId")
    public @ResponseBody ResponseEntity<List<Transaction>> getTransactionsByUserId (@RequestParam Long userId) {
        LOGGER.info(String.format("Request: getTransactionsByUserId :: %s", userId));
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        ResponseEntity<List<Transaction>> response = new ResponseEntity(transactions, HttpStatus.OK);
        LOGGER.info(String.format("Response: getTransactionsByUserId :: %s", response));
        return response;
    }

    @GetMapping("/getTransactionHistory")
    public @ResponseBody ResponseEntity<List<Transaction>> getTransactions () {
        LOGGER.info(String.format("Request: getTransactions"));
        List<Transaction> transactions = transactionService.getTransactions();
        ResponseEntity<List<Transaction>> response = new ResponseEntity(transactions, HttpStatus.OK);
        LOGGER.info(String.format("Response: getTransactions :: %s", response));
        return response;
    }

    @GetMapping("/getTransactionById")
    public @ResponseBody ResponseEntity<Transaction> getTransactionById (@RequestParam Long transactionId) {
        LOGGER.info(String.format("Request: getTransactionById"));
        Transaction transaction = transactionService.getTransactionById(transactionId);
        ResponseEntity<Transaction> response = new ResponseEntity(transaction, HttpStatus.OK);
        LOGGER.info(String.format("Response: getTransactionById :: %s", transaction));
        return response;
    }

    @PostMapping("/addTransaction")
    public @ResponseBody ResponseEntity<Transaction> addTransaction (@RequestBody AddTransactionRequest addTransactionRequest) {
        LOGGER.info(String.format("Request: addTransaction"));
        Transaction transaction = transactionService.addTransaction(addTransactionRequest);
        ResponseEntity<Transaction> response = new ResponseEntity(transaction, HttpStatus.OK);
        LOGGER.info(String.format("Response: addTransaction :: %s", transaction));
        return response;
    }
}
