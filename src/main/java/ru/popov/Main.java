package ru.popov;

import ru.popov.input.ConsoleUserInput;
import ru.popov.input.UserInput;
import ru.popov.service.ConverterService;
import ru.popov.service.MainLogicService;
import ru.popov.service.RatesGetter;
import ru.popov.service.RatesGetterFromFile;

public class Main {

    public static void main(String[] args) {

        String path = "./src/main/resources/opt/quoter2.json";

        RatesGetter ratesGetter = new RatesGetterFromFile(path);
        UserInput userInput = new ConsoleUserInput();
        ConverterService converterService = new ConverterService();

        new MainLogicService(ratesGetter, userInput, converterService)
                .run();
    }

}