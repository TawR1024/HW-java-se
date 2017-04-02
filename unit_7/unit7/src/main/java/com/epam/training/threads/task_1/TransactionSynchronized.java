package com.epam.training.threads.task_1;

import java.io.*;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class TransactionSynchronized  extends Thread{
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

    public HashSet<TransactionSynchronized.Requisites> dataParcer(String transferData) {
        Pattern transfer = Pattern.compile("(from: )([\\d])( to: )([\\d]+)( :)([\\d]+)(\\n)?");
        Matcher matcher = transfer.matcher(transferData);
        int senderId;
        int recipientId;
        int sum;
        HashSet<TransactionSynchronized.Requisites> requisitesHashSet = new HashSet<>();
        while (matcher.find()) {
            senderId = Integer.valueOf(matcher.group(2).trim());
            recipientId = Integer.valueOf(matcher.group(4).trim());
            sum = Integer.valueOf(matcher.group(6).trim());
            requisitesHashSet.add(new Requisites(senderId, recipientId, sum));
        }
        return requisitesHashSet;
    }

    public void doBankOperation(String filePath) throws FileNotFoundException {
        HashSet<Requisites> requisites = dataParcer(getTransferData(filePath));
        for (Requisites req :
                requisites) {
            Account sender = AccountBase.getAccountById(req.from);
            Account recipient = AccountBase.getAccountById(req.to);
            moneyTransfer(sender, recipient, req.sum);

        }

    }

    public void run(){
        try {
            doBankOperation(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
