package com.github.berenika2.restassuredframework.main.test.data.pet;

public enum PetTags {
    YOUNG(1,"young-pet"),
    ADULT(2,"adult-pet");

    private int id;
    private String TagName;

    public int getId() {
        return id;
    }

    public String getTagName() {
        return TagName;
    }

    PetTags(int id, String tagName) {
        this.id = id;
        this.TagName = tagName;
    }
}
