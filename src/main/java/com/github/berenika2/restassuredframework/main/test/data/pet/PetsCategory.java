package com.github.berenika2.restassuredframework.main.test.data.pet;

import com.github.berenika2.restassuredframework.main.pojo.pet.Pet;

public enum PetsCategory {
    DOGS(1,"dogs"),
    CATS(2, "cats"),
    OTHERS(3, "others");

    private int id;
    private String categoryName;

    public int getId() {
        return id;
    }

    public String getCategory() {
        return categoryName;
    }

   PetsCategory(int id, String categoryName){
        this.id = id;
        this.categoryName = categoryName;
   }
}
