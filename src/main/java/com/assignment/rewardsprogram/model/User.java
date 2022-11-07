package com.assignment.rewardsprogram.model;

public class User implements Comparable<User> {
    private Long userId;
    private String userName;

    public User (Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo (User that) {
        return Long.compare(this.userId, that.userId);
    }

    @Override
    public int hashCode () {
        return this.userId.intValue();
    }
}
