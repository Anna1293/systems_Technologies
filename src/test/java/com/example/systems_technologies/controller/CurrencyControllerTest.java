package com.example.systems_technologies.controller;

import com.example.systems_technologies.model.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
        String currencyCode = "USD";
        String dateValue = "2023-10-01";

        MvcResult mvcResult = this.mockMvc.perform(get(String.format("http://localhost:8080/api/currencies/%s?date=%s", currencyCode, dateValue))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        List<Currency> currencyList = objectMapper.readValue(jsonResponse, objectMapper.getTypeFactory().constructCollectionType(List.class, Currency.class));

        for (int i = 0; i < currencyList.size(); i++) {
            Assertions.assertEquals(LocalDate.of(2023, 10, 1), currencyList.get(i).getDate());
            Assertions.assertEquals(currencyCode, currencyList.get(i).getCode());
        }
    }
}
