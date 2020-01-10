package com.example.news.pojo;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "vehicleID")
    private String vehicleID;


}
