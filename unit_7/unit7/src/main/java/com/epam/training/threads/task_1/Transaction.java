package com.epam.training.threads.task_1;

import java.io.*;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class Transaction {

    public static void moneyTransfer(Account sender, Account recipient, int money) {
        if (sender.withdrawCash(money)) {
            recipient.addMoney(money);
        }
    }

    public String getTransferData(String transactionLog) throws FileNotFoundException {

        File transferData = new File(transactionLog);
        if (!transferData.exists())
            throw new FileNotFoundException();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(transferData));
        byte[] transfers = new byte[(int) transferData.length()];
        String data=null;
        try {
            inputStream.read(transfers);
            data = new String(transfers, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static

}
