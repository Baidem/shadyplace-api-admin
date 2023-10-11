package com.shadyplace.apiadmin.models.enums;

public enum FamilyLinkLabel {
    PARENT("Parent", "PAR"),
    GRANDPARENT("Grandparent", "GRP"),
    CHILD("Child", "CHD"),
    SIBLING("Sibling", "SIB"),
    UNCLE_AUNT("Uncle/Aunt", "UNC"),
    COUSIN("Cousin", "CUS"),
    NO_FAMILY("No Family Link", "N/A");
    private String label;
    private String abbreviation;

    FamilyLinkLabel(String label, String abbreviation) {
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
