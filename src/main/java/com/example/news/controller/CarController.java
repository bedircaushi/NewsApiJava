package com.example.news.controller;

import com.example.news.pojo.Car;
import com.example.news.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String Hello(){
        return "Hello";
    }

    @GetMapping("/cars")
    public List<Car> getAll(){
        return carService.findAll();
    }

}
