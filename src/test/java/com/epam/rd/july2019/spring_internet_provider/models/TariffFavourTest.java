package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TariffFavourTest {
    @Test
    public void testCreateTariffFavour() {
        //GIVEN
        TariffFavour tariffFavour = new TariffFavour();
        tariffFavour.setIdTariffFavour(1);
        tariffFavour.setIdSubscriber(3);
        tariffFavour.setIdTariff(2);
        tariffFavour.setIdFavour(4);
        //WHEN
        //THEN
        Assert.assertNotNull(tariffFavour);
        Assert.assertThat(tariffFavour, Matchers.isA(TariffFavour.class));
        Assert.assertThat(tariffFavour, Matchers.hasProperty("idTariffFavour", Matchers.is(1)));
        Assert.assertThat(tariffFavour, Matchers.hasProperty("idSubscriber", Matchers.is(3)));
        Assert.assertThat(tariffFavour, Matchers.hasProperty("idTariff", Matchers.is(2)));
        Assert.assertThat(tariffFavour, Matchers.hasProperty("idFavour", Matchers.is(4)));
    }
}
