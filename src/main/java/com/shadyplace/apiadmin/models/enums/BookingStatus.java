package com.shadyplace.apiadmin.models.enums;

public enum BookingStatus {
    //pending, validated, refused
    PENDING("pending", "P"),
    VALIDATED("validated", "V"),
    REFUSED("refused", "RS"),
    REFUNDED("refunded", "RN");

    private String label;
    private String abbreviation;

    BookingStatus(String label, String abbreviation) {
        this.label = label;
        this.abbreviation = abbreviation;
    }

    public String getLabel() {
        return label;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
