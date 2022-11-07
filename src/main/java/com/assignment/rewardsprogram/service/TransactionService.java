package com.assignment.rewardsprogram.service;

import com.assignment.rewardsprogram.model.AddTransactionRequest;
import com.assignment.rewardsprogram.model.Transaction;
import com.assignment.rewardsprogram.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByUserId (Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactions () {
        return transactionRepository.getTransactionList();
    }

    public Transaction getTransactionById (Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public Transaction addTransaction (AddTransactionRequest addTransactionRequest) {
        Long nextTransactionId = transactionRepository.getNextTransactionId();
        Transaction newTransaction = new Transaction(addTransactionRequest.getUserId(), nextTransactionId, addTransactionRequest.getAmount());
        transactionRepository.addTransaction(newTransaction);
        return newTransaction;
    }
}
