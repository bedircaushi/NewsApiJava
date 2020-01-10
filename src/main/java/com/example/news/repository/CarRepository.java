package com.example.news.repository;

import com.example.news.pojo.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, String>{
    List<Car> findAll();
}
