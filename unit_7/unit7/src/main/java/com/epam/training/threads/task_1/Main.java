package com.epam.training.threads.task_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(1000, 1, "Jack");
        Account account2 = new Account(1000, 2, "James");
        Account account3 = new Account(1000, 3, "John");

        AccountBase.addAccount(account1);
        AccountBase.addAccount(account2);
        AccountBase.addAccount(account3);

        String path = "src/main/java/com/epam/training/threads/task_1/transactions.txt";

        TransactionConcurrent transactionConcurrent1 = new TransactionConcurrent(path);
        TransactionConcurrent transactionConcurrent2 = new TransactionConcurrent(path);
        TransactionConcurrent transactionConcurrent3 = new TransactionConcurrent(path);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(transactionConcurrent1);
        executorService.execute(transactionConcurrent2);
        executorService.execute(transactionConcurrent3);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
