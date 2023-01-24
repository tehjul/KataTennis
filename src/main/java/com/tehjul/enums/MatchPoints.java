package com.tehjul.enums;

public enum MatchPoints {
    ZERO("love"),
    FIFTEEN("fifteen"),
    THIRTY("thirty"),
    FORTY("forty"),
    ADVANTAGE("advantage");

    public final String label;

    MatchPoints(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
