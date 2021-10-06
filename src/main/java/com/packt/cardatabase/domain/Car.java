package com.packt.cardatabase.domain;

import javax.persistence.*;

@Entity
public class Car {

    // los campos de la Entidad se mapean como columnas de una tabla de base de datos
    // la base de datos genera automaticamente el ID
    @Id // define que este sera el campo de la clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // campos que son introducidos manualmente
    private String brand, model, color, registerNumber;
    private int year, price;
    /**
     * la notacion @Column define detalles de una columna especifica
     * => '@Column(name="desc", nullable=false, length=512)' <=
     * private String description;
     */
    // definir que esta entidad tiene relacion de muchos a uno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    // definimos el constructor, los getters y los setters
    // el campo ID se genera Automaticamente
    public Car() {}

    public Car(String brand, String model, String color,
               String registerNumber, int year, int price, Owner owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        // clave externa que se conecta con la entidad Owner
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
