package com.epam.training.threads.task_1;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class TransactionConcurrent implements Runnable {
   private String file;
    private static Lock lock = new ReentrantLock();

    public TransactionConcurrent(String file) {
        this.file = file;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            doBankOperation(file);
        } catch (FileNotFoundException e) {

        }

    }

    public static void moneyTransfer(Account sender, Account recipient, int money) {
        if (sender.withdrawCash(money)) {
            recipient.addMoney(money);
        }
    }

    private String getTransferData(String transactionLog) throws FileNotFoundException {

        File transferData = new File(transactionLog);
        if (!transferData.exists())
            throw new FileNotFoundException();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(transferData));
        byte[] transfers = new byte[(int) transferData.length()];
        String data = null;
        try {
            inputStream.read(transfers);
            data = new String(transfers, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private Requisites dataParcer(String transferData) {
        Pattern transfer = Pattern.compile("(from: )([\\d])( to: )([\\d]+)( :)([\\d]+)(\\n)?");
        Matcher matcher = transfer.matcher(transferData);
        int senderId = 0;
        int recipientId = 0;
        int sum = 0;
        while (matcher.find()) {
            senderId = Integer.valueOf(matcher.group(2).trim());
            recipientId = Integer.valueOf(matcher.group(4).trim());
            sum = Integer.valueOf(matcher.group(6).trim());

        }
        return new Requisites(senderId, recipientId, sum);
    }

    public void doBankOperation(String filePath) throws FileNotFoundException {
        Requisites requisites = dataParcer(getTransferData(filePath));
        Account sender = AccountBase.getAccountById(requisites.from);
        Account recipient = AccountBase.getAccountById(requisites.to);
        moneyTransfer(sender, recipient, requisites.sum);

    }



    class Requisites {
        int from;
        int to;
        int sum;

        public Requisites(int from, int to, int sum) {
            this.from = from;
            this.to = to;
            this.sum = sum;
        }
    }

}
