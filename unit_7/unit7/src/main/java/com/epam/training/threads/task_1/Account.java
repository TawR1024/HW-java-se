package com.epam.training.threads.task_1;

/**
 * Created by Ilya Kulakov on 01.04.17.
 */
public class Account {
    private int balance;
    private int ownerId;
    private String ownerName;

    public Account(int balance, int ownerId, String ownerName) {
        this.balance = balance;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Boolean withdrawCash(int sum) {
        if (sum < balance) {
            balance = balance - sum;
            return true;
        }
        return false;
    }

    public Boolean addMoney(int sum) {
        balance = balance + sum;
        return true;
    }
}