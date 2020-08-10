package com.luckyboy.sun.daterecord.eight.mapstruct;

public enum Gender {
    BOY("男"),
    GIRL("女");
    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
