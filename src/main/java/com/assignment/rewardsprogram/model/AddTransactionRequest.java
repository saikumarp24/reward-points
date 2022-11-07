package com.assignment.rewardsprogram.model;

public class AddTransactionRequest {
    private Long userId;
    private double amount;

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public double getAmount () {
        return amount;
    }

    public void setAmount (double amount) {
        this.amount = amount;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("AddTransactionRequest{");
        sb.append("userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
