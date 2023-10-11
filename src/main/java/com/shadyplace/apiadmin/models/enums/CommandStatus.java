package com.shadyplace.apiadmin.models.enums;

public enum CommandStatus {
    CARD("card"),
    ABANDONED("abandoned"),
    AWAITING_PAYMENT("awaiting payment"),
    PAYMENT_MADE("payment made"),
    PAYMENT_REFUSED("payment refused");

    private String label;

    CommandStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
