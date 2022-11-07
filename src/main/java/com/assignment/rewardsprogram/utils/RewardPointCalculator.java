package com.assignment.rewardsprogram.utils;

import com.assignment.rewardsprogram.model.Transaction;

public class RewardPointCalculator {
    public static void calculateRewardPoints (Transaction transaction) {
        if (transaction.getTransactionAmount() > 50 && transaction.getTransactionAmount() <= 100) {
            transaction.setRewardPoints(Math.round(transaction.getTransactionAmount() - 50));
        } else if (transaction.getTransactionAmount() > 100) {
            transaction.setRewardPoints(Math.round(transaction.getTransactionAmount() - 100) * 2 + (100 - 50));
        } else transaction.setRewardPoints(0);
    }
}
