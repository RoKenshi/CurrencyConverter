package ru.popov.service;

import ru.popov.input.UserInput;

import java.util.Map;

public class MainLogicService {

    private final RatesGetter ratesGetter;
    private final UserInput userInput;
    private final ConverterService converterService;

    public MainLogicService(RatesGetter ratesGetter,
                            UserInput userInput, ConverterService converterService) {
        this.ratesGetter = ratesGetter;
        this.userInput = userInput;
        this.converterService = converterService;
    }

    public void run() {
        while (true) {
            try {
                this.userInput.showToUser("Введите сумму для конвертации");
                int balance = Integer.parseInt(this.userInput.getFromUser());

                if (balance < 0) {
                    this.userInput.showToUser("Баланс не может быть отрицательным");
                    throw new IllegalArgumentException();
                }

                this.userInput.showToUser("Введите валюту в которую будем конвертировать");
                String typeCurrency = this.userInput.getFromUser();
                Map<String, Double> ratesList = ratesGetter.getCurrentRates();

                if (!ratesList.containsKey(typeCurrency)) {
                    throw new IllegalArgumentException();
                }

                Double convertCurrency = converterService.convertCurrency(balance, ratesList.get(typeCurrency));
                this.userInput.showToUser(String.valueOf(convertCurrency));
                break;

            } catch (IllegalArgumentException e) {
                this.userInput.showToUser("Неверный формат ввода");
            }
        }
    }
}