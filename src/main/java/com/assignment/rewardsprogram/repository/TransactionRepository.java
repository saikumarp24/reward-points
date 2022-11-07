package com.assignment.rewardsprogram.repository;

import com.assignment.rewardsprogram.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {
    List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransactionList () {
        return transactionList;
    }

    public Transaction findById (Long transactionId) {
        return transactionList.stream()
            .filter(transaction -> Objects.equals(transaction.getTransactionId(), transactionId)).findFirst()
            .orElse(null);
    }

    public void addTransaction (Transaction transaction) {
        transactionList.add(transaction);
    }

    public void deleteTransaction (Transaction transaction) {
        transactionList.remove(transaction);
    }

    public void updateTransactionAmount (Long transactionId, double updatedAmount) {
        transactionList.stream().filter(transaction1 -> Objects.equals(transaction1.getTransactionId(), transactionId))
            .forEach(transaction1 -> transaction1.setTransactionAmount(updatedAmount));
    }

    public void updateTransactionDate (Long transactionId, Date updatedDate) {
        transactionList.stream().filter(transaction1 -> Objects.equals(transaction1.getTransactionId(), transactionId))
            .forEach(transaction1 -> transaction1.setTransactionDate(updatedDate));
    }

    public List<Transaction> findByUserId (Long userId) {
        return transactionList.stream().filter(transaction -> Objects.equals(transaction.getUserId(), userId))
            .collect(Collectors.toList());
    }

    public Long getNextTransactionId () {
        return transactionList.stream().sorted((o1, o2) -> o1.getTransactionId().compareTo(o2.getTransactionId()))
            .findFirst().map(transaction -> transaction.getTransactionId() + 1).orElse(1L);
    }
}
