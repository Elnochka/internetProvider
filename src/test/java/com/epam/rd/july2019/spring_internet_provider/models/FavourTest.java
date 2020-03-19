package com.epam.rd.july2019.spring_internet_provider.models;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class FavourTest {
    @Test
    public void testCreateFavour() {
        //GIVEN
        Favour favour = new Favour();
        favour.setIdFavour(1);
        favour.setNameFavour("TV");
        //WHEN
        //THEN
        Assert.assertNotNull(favour);
        Assert.assertThat(favour, Matchers.isA(Favour.class));
        Assert.assertThat(favour, Matchers.hasProperty("idFavour", Matchers.is(1)));
        Assert.assertThat(favour, Matchers.hasProperty("nameFavour", Matchers.is("TV")));
    }
}
