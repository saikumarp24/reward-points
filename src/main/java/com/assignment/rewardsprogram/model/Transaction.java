package com.assignment.rewardsprogram.model;

import com.assignment.rewardsprogram.utils.RewardPointCalculator;

import java.util.Date;

public class Transaction {
    private Long userId;
    private Long transactionId;
    private double transactionAmount;
    private Date transactionDate;

    private long rewardPoints;

    public Transaction (Long userId, Long transactionId, double transactionAmount) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = new Date();
        RewardPointCalculator.calculateRewardPoints(this);
    }

    public Transaction (Long userId, Long transactionId, double transactionAmount, Date transactionDate) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        RewardPointCalculator.calculateRewardPoints(this);
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Long getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmount () {
        return transactionAmount;
    }

    public void setTransactionAmount (double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate () {
        return transactionDate;
    }

    public void setTransactionDate (Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getRewardPoints () {
        return rewardPoints;
    }

    public void setRewardPoints (long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("transactionId=").append(transactionId);
        sb.append(", transactionAmount=").append(transactionAmount);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", transactionDateInMillis=").append(transactionDate.getTime());
        sb.append(", rewardPoints=").append(rewardPoints);
        sb.append('}');
        return sb.toString();
    }
}
