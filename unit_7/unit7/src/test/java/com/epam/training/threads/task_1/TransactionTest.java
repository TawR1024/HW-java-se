package com.epam.training.threads.task_1;

import org.junit.Test;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class TransactionTest {


    public String path = "src/main/java/com/epam/training/threads/task_1/transactions.txt";

    @Test
    public void moneyTransfer() throws Exception {

    }

    @Test
    public void getTransferData() throws Exception {
        Transaction transaction = new Transaction();
        System.out.println(transaction.getTransferData(path));
    }

    @Test
    public void dataParcer() throws Exception {
        Transaction transaction = new Transaction();
        System.out.println(transaction.dataParcer(transaction.getTransferData(path)).toString());

    }

    @Test
    public void doBankOperation() throws Exception {
        Account account1 = new Account(600, 1, "Jack");
        Account account2 = new Account(256, 2, "James");

        AccountBase.addAccount(account1);
        AccountBase.addAccount(account2);

        Transaction transaction = new Transaction();
        System.out.println(transaction.dataParcer(transaction.getTransferData(path)).toString());
        transaction.doBankOperation(path);

        System.out.println(account2.getBalance());

    }

}