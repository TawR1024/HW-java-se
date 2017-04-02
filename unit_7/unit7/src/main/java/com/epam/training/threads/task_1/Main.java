package com.epam.training.threads.task_1;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(600, 1, "Jack");
        Account account2 = new Account(256, 2, "James");

        AccountBase.addAccount(account1);
        AccountBase.addAccount(account2);

        String path = "src/main/java/com/epam/training/threads/task_1/transactions.txt";

        File file = new File(path);
        if(file.exists())
            System.out.println("rock");

        TransactionConcurrent transactionConcurrent1 = new TransactionConcurrent(path);
        TransactionConcurrent transactionConcurrent2 = new TransactionConcurrent(path);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(transactionConcurrent1);
        executorService.execute(transactionConcurrent2);



    }


}
