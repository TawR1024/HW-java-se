package com.epam.training.threads.task_1;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
    Account account1 = new Account(156, 1, "Jack");
    Account account2 = new Account(256, 2, "James");
        account1.addMoney(4);
        account2.withdrawCash(200);
    }


}
