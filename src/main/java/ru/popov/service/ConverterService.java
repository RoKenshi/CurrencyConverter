package ru.popov.service;

public class ConverterService {

    public Double convertCurrency(double balance, double currency) {
        return balance / currency;
    }
}
