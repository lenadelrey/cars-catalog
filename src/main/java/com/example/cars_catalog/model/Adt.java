package com.example.cars_catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Adt {

    @Id
    @Column(name = "car_id")
    private Long car_id;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Adt(String model, String description, float price, int year, User user) {
        this.model = model;
        this.description = description;
        this.price = price;
        this.year = year;
        this.user = user;
    }

}
