package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.models.Account;
import com.epam.rd.july2019.spring_internet_provider.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AccountControllerTest {

    private final AccountService accountServiceMock = Mockito.mock(AccountService.class);
    private final AccountController accountController = new AccountController();
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    private Account account;

    @Before
    public void initAccount(){
        account = new Account();
        account.setIdAccount(1);
        account.setAccount(44444444L);
        account.setBalance(250d);
    }

    @Test
    public void testList() throws Exception {
        //GIVEN
        List<Account> accountArrayList = new ArrayList<>();
        accountArrayList.add(account);
        ReflectionTestUtils.setField(accountController,"accountService", accountServiceMock);
        //WHEN
        given(this.accountServiceMock.queryElements()).willReturn(accountArrayList);
        //THEN
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(view().name("accountView"))
                .andExpect(model().attribute("accountList", hasSize(1)))
                .andExpect(model().attribute("accountList", hasItem(
                        allOf(
                                hasProperty("idAccount", is(1)),
                                hasProperty("account", is(44444444L)),
                                hasProperty("balance", is(250d))
                                )
                )));
        verify(accountServiceMock, times(1)).queryElements();
        verifyNoMoreInteractions(accountServiceMock);
    }

    @Test
    public void findIdAccountTest() throws Exception {
        //GIVEN
        String idAccount = "1";
        ReflectionTestUtils.setField(accountController,"accountService", accountServiceMock);
        //WHEN
        given(this.accountServiceMock.findElementId(1)).willReturn(account);
        //THEN
        mockMvc.perform(get("/editAccount")
                .param("idAccount", idAccount))
                .andExpect(status().isOk())
                .andExpect(view().name("accountEditView"))
                .andExpect(model().attribute("accountForm", hasProperty("idAccount", is(1))))
                .andExpect(model().attribute("accountForm", hasProperty("account", is(44444444L))))
                .andExpect(model().attribute("accountForm", hasProperty("balance", is(250d))));

        verify(accountServiceMock, times(1)).findElementId(1);
        verifyNoMoreInteractions(accountServiceMock);

    }

    @Test
    public void insertAccountTest() throws Exception {
        //GIVEN
        Account accountForMethod = new Account();
        accountForMethod.setIdAccount(1);
        accountForMethod.setAccount(44444444L);
        accountForMethod.setBalance(250d);
        ReflectionTestUtils.setField(accountController,"accountService", accountServiceMock);
        //WHEN
        doNothing().when(this.accountServiceMock).insertElement(accountForMethod);
        //THEN
        mockMvc.perform(post("/createAccount")
                .param("idAccount", "1")
                .param("account", "44444444")
                .param("balance", "250")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attribute("accountForm", hasProperty("idAccount", is(1))))
                .andExpect(model().attribute("accountForm", hasProperty("account", is(44444444L))))
                .andExpect(model().attribute("accountForm", hasProperty("balance", is(250d))));

        verify(accountServiceMock, times(1)).insertElement(accountForMethod);
        verifyNoMoreInteractions(accountServiceMock);

    }

    @Test
    public void updateAccountTest() throws Exception {
        //GIVEN
        Account accountForMethod = new Account();
        accountForMethod.setIdAccount(1);
        accountForMethod.setAccount(44444444L);
        accountForMethod.setBalance(250d);
        ReflectionTestUtils.setField(accountController,"accountService", accountServiceMock);
        //WHEN
        doNothing().when(this.accountServiceMock).updateElement(accountForMethod);
        //THEN
        mockMvc.perform(post("/editAccount")
                .param("idAccount", "1")
                .param("account", "44444444")
                .param("balance", "250")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attribute("accountForm", hasProperty("idAccount", is(1))))
                .andExpect(model().attribute("accountForm", hasProperty("account", is(44444444L))))
                .andExpect(model().attribute("accountForm", hasProperty("balance", is(250d))));

        verify(accountServiceMock, times(1)).updateElement(accountForMethod);
        verifyNoMoreInteractions(accountServiceMock);

    }

    @Test
    public void deleteAccountTest() throws Exception {
        //GIVEN
        String idAccount = "1";
        ReflectionTestUtils.setField(accountController,"accountService", accountServiceMock);
        //WHEN
        doNothing().when(this.accountServiceMock).deleteElement(1);
        //THEN
        mockMvc.perform(get("/deleteAccount")
                .param("idAccount", idAccount))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        verify(accountServiceMock, times(1)).deleteElement(1);
        verifyNoMoreInteractions(accountServiceMock);

    }


}
