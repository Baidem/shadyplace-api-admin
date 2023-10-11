package com.shadyplace.apiadmin.models.enums;

public enum LineLabel {
    PREMIUM("premium"),
    BACK("back");

    private String label;

    LineLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
