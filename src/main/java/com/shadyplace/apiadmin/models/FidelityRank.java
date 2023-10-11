package com.shadyplace.apiadmin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "fidelity_rank")
public class FidelityRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Fidelity rank's label cannot be blank.")
    @NotNull(message = "FidelityRank must be defined")
    private String label;
    @Column(columnDefinition = "float(5,2)", name = "discount_price", nullable = false)
    @PositiveOrZero(message = "Fidelity rank discount price cannot be negative")
    private double discountPrice;

    public FidelityRank() {
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
