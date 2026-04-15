package com.solvd.railway.enums;

public enum LogLevel {

    INFO("INFORMATION: "),
    WARN("WARNING: "),
    ERROR("ERROR: "),
    TITLE("");

    private final String prefix;

    LogLevel(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}