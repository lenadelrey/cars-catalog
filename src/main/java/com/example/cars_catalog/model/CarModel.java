package com.example.cars_catalog.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarModel {

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
    private UserModel userModel;

    public CarModel(Long car_id, String model, String description, float price, int year, UserModel userModel) {
        this.car_id = car_id;
        this.model = model;
        this.description = description;
        this.price = price;
        this.year = year;
        this.userModel = userModel;
    }

    public CarModel() {
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "car_id=" + car_id +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", userModel=" + userModel +
                '}';
    }
}
