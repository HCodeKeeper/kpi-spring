package com.example.lab2_3.services.impl;

import com.example.lab2_3.entities.Currency;
import com.example.lab2_3.repositories.CurrencyRepository;
import com.example.lab2_3.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceBean implements CurrencyService {
    private final CurrencyRepository currencyRepo;

    @Override
    public List<Currency> getAll() {
        return currencyRepo.findAll();
    }

    @Override
    public Currency create(Currency currency) {
        return currencyRepo.save(currency);
    }

    @Override
    public void delete(Long id) {
        currencyRepo.deleteById(id);
    }

    @Override
    public void update(Long id, Currency currency) {
        currencyRepo.findById(id).map(toUpdate ->{
                    toUpdate.setName(currency.getName());
                    return currencyRepo.save(toUpdate);
                });
    }
}
