package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.models.Favour;
import com.epam.rd.july2019.spring_internet_provider.service.FavourService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class FavourControllerTest {

    private final List<Favour> favourList = new ArrayList<>();

    @Before
    public void initFavour(){
        Favour favour = new Favour();
        favour.setIdFavour(1);
        favour.setNameFavour("TV");
        favourList.add(favour);
    }


    private final FavourService favourServiceMock = Mockito.mock(FavourService.class);
    private final FavourController favourController = new FavourController();
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(favourController).build();

    @Test
    public void findIdFavourTest() throws Exception {
        //GIVEN
        String idFavour = "1";
        Favour favour = new Favour();
        favour.setIdFavour(1);
        favour.setNameFavour("TV");
        ReflectionTestUtils.setField(favourController,"favourService", favourServiceMock);
        //WHEN
        given(this.favourServiceMock.findElementId(1)).willReturn(favour);
        //THEN
        mockMvc.perform(get("/editFavour")
                .param("idFavour", idFavour))
                .andExpect(status().isOk())
                .andExpect(view().name("favourEditView"))
                .andExpect(model().attribute("favourForm", hasProperty("idFavour", is(1))))
                .andExpect(model().attribute("favourForm", hasProperty("nameFavour", is("TV"))));

        verify(favourServiceMock, times(1)).findElementId(1);
        verifyNoMoreInteractions(favourServiceMock);

    }

    @Test
    public void insertFavourTest() throws Exception {
        //GIVEN
        String idFavour = "1";
        Favour favour = new Favour();
        favour.setIdFavour(1);
        favour.setNameFavour("TV1");
        ReflectionTestUtils.setField(favourController,"favourService", favourServiceMock);
        //WHEN
        doNothing().when(this.favourServiceMock).insertElement(favour);
        //THEN
        mockMvc.perform(post("/createFavour")
                .param("idFavour", "1")
                .param("nameFavour", "TV1")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attribute("favourForm", hasProperty("idFavour", is(1))))
                .andExpect(model().attribute("favourForm", hasProperty("nameFavour", is("TV1"))));

        verify(favourServiceMock, times(1)).insertElement(favour);
        verifyNoMoreInteractions(favourServiceMock);

    }

    @Test
    public void updateFavourTest() throws Exception {
        //GIVEN
        String idFavour = "1";
        Favour favour = new Favour();
        favour.setIdFavour(1);
        favour.setNameFavour("TVs");
        ReflectionTestUtils.setField(favourController,"favourService", favourServiceMock);
        //WHEN
        doNothing().when(this.favourServiceMock).updateElement(favour);
        //THEN
        mockMvc.perform(post("/editFavour")
                .param("idFavour", idFavour)
                .param("nameFavour", "TVs")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attribute("favourForm", hasProperty("idFavour", is(1))))
                .andExpect(model().attribute("favourForm", hasProperty("nameFavour", is("TVs"))));

        verify(favourServiceMock, times(1)).updateElement(favour);
        verifyNoMoreInteractions(favourServiceMock);

    }

    @Test
    public void deleteFavourTest() throws Exception {
        //GIVEN
        String idFavour = "1";
        ReflectionTestUtils.setField(favourController,"favourService", favourServiceMock);
        //WHEN
        doNothing().when(this.favourServiceMock).deleteElement(1);
        //THEN
        mockMvc.perform(get("/deleteFavour")
                .param("idFavour", idFavour))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        verify(favourServiceMock, times(1)).deleteElement(1);
        verifyNoMoreInteractions(favourServiceMock);

    }

    @Test
    public void testList() {
        //GIVEN
        FavourService favourService = Mockito.mock(FavourService.class);
        FavourController favourController = new FavourController();
        ReflectionTestUtils.setField(favourController,"favourService", favourService);
        //WHEN
        Mockito.when(favourService.queryElements()).thenReturn(favourList);
        ModelAndView modelAndView = favourController.list();
        ModelMap model = modelAndView.getModelMap();
        List<Favour> modelList = (List<Favour>) model.get("favourList");
        //THEN
        Assert.assertEquals(1, modelList.size());
        Assert.assertThat(modelList.get(0).getIdFavour(), is(1));
        Assert.assertThat(modelList.get(0).getNameFavour(), is("TV"));
    }
}
