package com.shadyplace.apiadmin.models.enums;

public enum EquipmentOption {
    ONE_BED("1 bed"),
    TWO_BEDS("2 beds"),
    ONE_SEAT("1 seat"),
    ONE_BED_ONE_SEAT("1 bed + 1 seat"),
    TWO_SEATS("2 seats"),
    NOTHING("nothing");

    private String label;

    EquipmentOption(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
