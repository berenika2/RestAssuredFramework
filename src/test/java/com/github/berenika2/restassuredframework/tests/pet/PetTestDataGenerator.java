package com.github.berenika2.restassuredframework.tests.pet;

import com.github.berenika2.restassuredframework.main.pojo.pet.Category;
import com.github.berenika2.restassuredframework.main.pojo.pet.Pet;
import com.github.berenika2.restassuredframework.main.pojo.pet.Tag;
import com.github.berenika2.restassuredframework.main.test.data.TestDataGenerator;
import com.github.berenika2.restassuredframework.main.test.data.pet.PetTags;
import com.github.berenika2.restassuredframework.main.test.data.pet.PetsCategory;
import com.github.berenika2.restassuredframework.main.test.data.pet.PetStatus;

import java.util.Collections;
import java.util.Random;

public class PetTestDataGenerator extends TestDataGenerator {

    public Pet generatePet(){

    PetsCategory petCategory = randomPetCategory();
    PetTags petTags = randomPetTag();
    PetStatus petStatus = randomStatus();

    Category category = new Category();
    category.setId(petCategory.getId());
    category.setName(petCategory.getCategory());

    Tag tag = new Tag();
    tag.setId(petTags.getId());
    tag.setName(petTags.getTagName());

    Pet pet = new Pet();
    pet.setId(faker().number().numberBetween(1,9999));
    pet.setName(faker().funnyName().name());
    pet.setCategory(category);
    pet.setStatus(petStatus.getStatus());
    pet.setTags(Collections.singletonList(tag));
    pet.setPhotoUrls(Collections.singletonList(faker().internet().url()));

    return pet;

    }

    private PetsCategory randomPetCategory() {
        int pick = new Random().nextInt(PetsCategory.values().length);
        return PetsCategory.values()[pick];
    }
    private PetTags randomPetTag(){
        int pick = new Random().nextInt(PetTags.values().length);
        return PetTags.values()[pick];
    }

    private PetStatus randomStatus() {
        int pick = new Random().nextInt(PetStatus.values().length);
        return PetStatus.values()[pick];

    }
}
