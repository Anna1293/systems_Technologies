package com.example.systems_technologies.repository;

import com.example.systems_technologies.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);
}
