package com.epam.training.threads.task_1;

import java.util.HashSet;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class AccountBase {
    private static HashSet<Account> accounts = new HashSet<>();

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static Account getAccountById(int id) {
        for (Account account:accounts) {
            if(account.getOwnerId() == id){
                return account;
            }
        }
        return null;
    }

        public int getAllMoney(){
        int money =0;
            for (Account account :
                    accounts) {
                money += account.getBalance();
            }
            return  money;
        }

}
