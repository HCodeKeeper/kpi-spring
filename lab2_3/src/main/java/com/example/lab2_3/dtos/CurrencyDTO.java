package com.example.lab2_3.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CurrencyDTO {
    @JsonProperty("exchangeDate")
    private Date exchangeDate;
    @JsonProperty("sourceCurrency")
    private String sourceCurrency;
    @JsonProperty("targetCurrency")
    private String targetCurrency;
    @JsonProperty("rate")
    private double rate;
}
