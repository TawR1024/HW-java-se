package com.epam.training.threads.task_1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class TransactionSynchronized {
    private String file;

    public TransactionSynchronized(String file) {
        this.file = file;
    }


    public static void moneyTransfer(Account sender, Account recipient, int money) {
        System.out.println("Transfer money from" + sender.getOwnerId() + " to " + recipient.getOwnerId());
        synchronized (sender){
            if (sender.withdrawCash(money)) {
                recipient.addMoney(money);
            }

        }
    }

    public String getTransferData(String transactionLog) throws FileNotFoundException {
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

    public Requisites dataParcer(String transferData) {
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

        @Override
        public String toString() {
            return from + " " + to + " " + sum;
        }
    }

}
