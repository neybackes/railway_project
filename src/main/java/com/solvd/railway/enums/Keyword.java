package com.solvd.railway.enums;

public enum Keyword {
    TRAIN("train"),
    WAGON("wagon"),
    CARGO("cargo"),
    RAILWAY("railway");

    private final String word;

    Keyword(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
