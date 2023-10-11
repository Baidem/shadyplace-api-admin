package com.shadyplace.apiadmin.models;


import com.shadyplace.apiadmin.models.enums.FamilyLinkLabel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "family_link")
public class FamilyLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Family link's label cannot be null.")
    private FamilyLinkLabel label;
    @Column(name = "discount_rate", columnDefinition = "float(2,2)",nullable = false)
    @PositiveOrZero(message = "Family link's discount rate cannot be negative.")
    @NotNull(message = "Family link's discount rate cannot be null.")
    private double discountRate;

    public FamilyLink() {
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public FamilyLinkLabel getLabel() {
        return label;
    }

    public long getId() {
        return id;
    }

    public void setLabel(FamilyLinkLabel label) {
        this.label = label;
    }
}
