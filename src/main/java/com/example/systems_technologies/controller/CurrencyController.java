package com.example.systems_technologies.controller;

import com.example.systems_technologies.model.Currency;
import com.example.systems_technologies.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{code}")
    public List<Currency> getCurrency(@PathVariable String code, @RequestParam LocalDate date) {
        return currencyService.getCurrencyRates(code, date);
    }
}
