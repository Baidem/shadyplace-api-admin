package com.shadyplace.apiadmin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "equipement")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "option",unique = true, nullable = false)
    @NotNull(message = "Equipement option cannot be null.")
    @NotBlank(message = "Equipement option cannot be blank.")
    private String option;
    @Column(columnDefinition = "double(5,2)", nullable = false)
    @NotNull(message = "Equipement price cannot be null.")
    @PositiveOrZero(message = "Equipement price cannot be negative.")
    private double price;

    public Equipment() {
    }

    public Equipment(String option, double price) {
        this.option = option;
        this.price = price;
    }

    public Equipment(long id, String option, double price) {
        this.id = id;
        this.option = option;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
