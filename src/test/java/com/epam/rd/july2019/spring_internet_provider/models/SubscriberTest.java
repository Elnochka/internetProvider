package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SubscriberTest {
    @Test
    public void testCreateSubscriber() {
        //GIVEN
        Subscriber subscriber = new Subscriber();
        subscriber.setIdSubscriber(1);
        subscriber.setNameSubscriber("Admin");
        subscriber.setAccount(1);
        subscriber.setBlocked(false);
        //WHEN
        //THEN
        Assert.assertNotNull(subscriber);
        Assert.assertThat(subscriber, Matchers.isA(Subscriber.class));
        Assert.assertThat(subscriber, Matchers.hasProperty("idSubscriber", Matchers.is(1)));
        Assert.assertThat(subscriber, Matchers.hasProperty("nameSubscriber", Matchers.is("Admin")));
        Assert.assertThat(subscriber, Matchers.hasProperty("account", Matchers.is(1)));
        Assert.assertThat(subscriber, Matchers.hasProperty("blocked", Matchers.is(false)));
    }
}
