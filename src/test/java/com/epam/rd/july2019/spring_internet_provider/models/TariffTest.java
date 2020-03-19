package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TariffTest {
    @Test
    public void testCreateTariff() {
        //GIVEN
        Tariff tariff = new Tariff();
        tariff.setIdTariff(1);
        tariff.setNameTariff("optimal");
        tariff.setPrice(400.36);
        tariff.setPathFile("d:/data.txt");
        //WHEN
        //THEN
        Assert.assertNotNull(tariff);
        Assert.assertThat(tariff, Matchers.isA(Tariff.class));
        Assert.assertThat(tariff, Matchers.hasProperty("idTariff", Matchers.is(1)));
        Assert.assertThat(tariff, Matchers.hasProperty("nameTariff", Matchers.is("optimal")));
        Assert.assertThat(tariff, Matchers.hasProperty("price", Matchers.is(400.36)));
        Assert.assertThat(tariff, Matchers.hasProperty("pathFile", Matchers.is("d:/data.txt")));
    }
}
