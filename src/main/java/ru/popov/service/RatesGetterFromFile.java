package ru.popov.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class RatesGetterFromFile implements RatesGetter {

    private final String path;

    public RatesGetterFromFile(String path) {
        this.path = path;
    }

    @Override
    public Map<String, Double> getCurrentRates() {

        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(path));
            Type ratesMapType = new TypeToken<Map<String, Double>>() {
            }.getType();
            return gson.fromJson(br, ratesMapType);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден", e);
        }
    }

}
