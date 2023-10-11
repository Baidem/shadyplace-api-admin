package com.shadyplace.apiadmin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "_line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Line's label cannot be null.")
    @NotBlank(message = "Line's label cannot be blank.")
    private String label;
    @Column(columnDefinition = "float(5,2)", nullable = false)
    @PositiveOrZero(message = "Line's price cannot be negative.")
    @NotNull(message = "Line's price cannot be null.")
    private double price;

    public Line() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
