package ru.popov.service;

import java.util.Map;

public interface RatesGetter {
    Map<String, Double> getCurrentRates();
}
