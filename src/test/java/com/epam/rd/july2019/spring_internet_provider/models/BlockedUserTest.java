package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BlockedUserTest {
    @Test
    public void testCreateBlockedUser() {
        //GIVEN
        BlockedUser blockedUser = new BlockedUser();
        blockedUser.setIdBlockedSubscriber(1);
        blockedUser.setIdBlockedAccount(2);
        blockedUser.setIdBlockedTariff(3);
        blockedUser.setUserBalance(534.46);
        blockedUser.setUserPrice(534.46);
        blockedUser.setUserBlocked(true);
        //WHEN
        //THEN
        Assert.assertNotNull(blockedUser);
        Assert.assertThat(blockedUser, Matchers.isA(BlockedUser.class));
        Assert.assertThat(blockedUser, Matchers.hasProperty("idBlockedSubscriber", Matchers.is(1)));
        Assert.assertThat(blockedUser, Matchers.hasProperty("idBlockedAccount", Matchers.is(2)));
        Assert.assertThat(blockedUser, Matchers.hasProperty("idBlockedTariff", Matchers.is(3)));
        Assert.assertThat(blockedUser, Matchers.hasProperty("userBalance", Matchers.is(534.46)));
        Assert.assertThat(blockedUser, Matchers.hasProperty("userPrice", Matchers.is(534.46)));
        Assert.assertThat(blockedUser, Matchers.hasProperty("userBlocked", Matchers.is(true)));
    }
}
