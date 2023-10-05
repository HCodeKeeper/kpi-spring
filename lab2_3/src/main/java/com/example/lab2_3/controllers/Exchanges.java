package com.example.lab2_3.controllers;
import com.example.lab2_3.dtos.CurrencyDTO;
import com.example.lab2_3.services.impl.ExchangeServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/exchanges")
public class Exchanges {
    @Autowired
    private ExchangeServiceBean exchangeService;

    @GetMapping("exchanges/latest")
    public String getAllExchanges(Model model){
        List<CurrencyDTO> exchanges = exchangeService.getAllTodayCurrencies();
        model.addAttribute("exchanges", exchanges);
        return "all_exchanges";
    }

    @GetMapping("exchange/{source_curr}/{target_curr}/{dateFrom}/{dateTo}")
    public String getAllExchanges(Model model,
                                  @PathVariable("source_curr") final String source_curr,
                                  @PathVariable("target_curr") final String target_curr,
                                  @PathVariable("dateFrom") final Date dateFrom,
                                  @PathVariable("dateTo") final Date dateTo
                                  ){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTo);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date includingDateTo = calendar.getTime();

        List<CurrencyDTO> exchanges = exchangeService.getAllCurrenciesByDate(dateFrom, includingDateTo, source_curr, target_curr);
        model.addAttribute("exchanges", exchanges);
        return "exchange_by_date";
    }
}
