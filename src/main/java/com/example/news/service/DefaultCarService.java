package com.example.news.service;

import com.example.news.pojo.Car;
import com.example.news.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultCarService implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
