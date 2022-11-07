package com.assignment.rewardsprogram.repository;

import com.assignment.rewardsprogram.constants.Constants;
import com.assignment.rewardsprogram.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Repository
public class RewardRepository {

    @Autowired
    TransactionRepository transactionRepository;

    public long getTotalRewards () {
        return transactionRepository.getTransactionList().stream().map(Transaction::getRewardPoints).reduce(Long::sum)
            .orElse(0L);
    }

    public long getLastThreeMonthsRewards () {
        Date currentDate = new Date();
        return transactionRepository.getTransactionList().stream()
            .filter(transaction -> currentDate.getTime() - transaction.getTransactionDate()
                .getTime() > Constants.millisEquivalentFor90Days).map(Transaction::getRewardPoints).reduce(Long::sum)
            .orElse(0L);
    }

    public long getTotalRewardsByUserId (Long userId) {
        return transactionRepository.getTransactionList().stream()
            .filter(transaction -> Objects.equals(transaction.getUserId(), userId)).map(Transaction::getRewardPoints)
            .reduce(Long::sum).orElse(0L);
    }

    public long getLastThreeMonthsRewardsByUserId (Long userId) {
        Date currentDate = new Date();
        return transactionRepository.getTransactionList().stream()
            .filter(transaction -> Objects.equals(transaction.getUserId(), userId))
            .filter(transaction -> TimeUnit.DAYS.convert(currentDate.getTime() - transaction.getTransactionDate()
                .getTime(), TimeUnit.MILLISECONDS) <= 90).map(Transaction::getRewardPoints).reduce(Long::sum)
            .orElse(0L);
    }


}
