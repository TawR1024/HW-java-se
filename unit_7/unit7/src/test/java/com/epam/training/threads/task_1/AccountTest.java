package com.epam.training.threads.task_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ilya Kulakov on 02.04.17.
 */
public class AccountTest {
    Account account ;

    @Before
    public void init(){
        account = new Account(10, 1, "OwnerName");
    }

    @Test
    public void testThatWeCanAddMoney() throws Exception {

        assertTrue(account.addMoney(20));
    }

    @Test
    public void testThatWecanWithdrawMoney() throws Exception {
        assertTrue(account.withdrawCash(5));
    }

    @Test
    public void testThatWecanotWithdrawMoneyMoreThenHave() throws Exception {
        assertFalse(account.withdrawCash(50));
    }
}