package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    @Test
    public void testCreateAccount() {
        //GIVEN
        Account account = new Account();
        account.setIdAccount(1);
        account.setAccount(2345678L);
        account.setBalance(400.36);
        //WHEN
        //THEN
        Assert.assertNotNull(account);
        Assert.assertThat(account, Matchers.isA(Account.class));
        Assert.assertThat(account, Matchers.hasProperty("idAccount", Matchers.is(1)));
        Assert.assertThat(account, Matchers.hasProperty("account", Matchers.is(2345678L)));
        Assert.assertThat(account, Matchers.hasProperty("balance", Matchers.is(400.36)));
    }
}
