package vn.demo.lesson1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import vn.demo.lesson1.model.Car;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;
    static final String APP_NAME = "appName";
    static final String CARS = "cars";

    @GetMapping(value = "/")
    public String getHome(Model model) throws IOException {
        List<List<String>> listValues = new ArrayList<>();
        try (BufferedReader bufferedCar = new BufferedReader(new FileReader("src/main/resources/static/data/car.csv"));) {
            String line;
            while ((line = bufferedCar.readLine()) != null) {
                String[] values = line.split(",");
                listValues.add(Arrays.asList(values));
            }
        }
        Car[] carCollection = new Car[listValues.size()];
        for (int i = 0; i < carCollection.length; i++) {
            carCollection[i] = createCar(listValues.get(i));
        }
        model.addAttribute(CARS, carCollection);
        model.addAttribute(APP_NAME, appName);
        return "home";
    }

    @GetMapping(value = "/bestsale")
    public String getCar(Model model) {
        Car[] carCollection = { new Car(1, "Triton 4x4 Premium", "Mitsubishi", 869, "triton"),
                new Car(2, "Ranger", "Ford", 1205, "ranger"), new Car(3, "XL7 Premium", "Suzuki", 620, "XL7") };
        model.addAttribute(CARS, carCollection);
        model.addAttribute(APP_NAME, appName);
        return "bestsale";
    }

    public static Car createCar(List<String> listValues) {
        int id = Integer.parseInt(listValues.get(0));
        String name = listValues.get(1);
        String manufacturer = listValues.get(2);
        int price = Integer.parseInt(listValues.get(3));
        return new Car(id, name, manufacturer, price, "");
    }
}
