package com.example.systems_technologies.service;

import com.example.systems_technologies.model.Currency;
import com.example.systems_technologies.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;


    public List<Currency> getCurrencyRates(String code, LocalDate date) {
        LocalDate startDate = date.minusDays(7); // волшебная цифра
        return currencyRepository.findByCodeAndDateBetween(code, startDate, date);
    }
}
