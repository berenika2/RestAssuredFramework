package com.github.berenika2.restassuredframework.tests.pet;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.pet.Pet;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreatePetTests extends SuiteTestBase {

    private Pet actualPet;

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Pet pet = new PetTestDataGenerator().generatePet();

        actualPet = given().body(pet).contentType("application/json")
                .when().post("pet")
                .then().statusCode(200).extract().as(Pet.class);

        assertEquals(actualPet.getId(), pet.getId(), "Pet id");
        assertEquals(actualPet.getName(), pet.getName(), "Pet name");
        System.out.println(actualPet.getId());
    }

    @AfterMethod
    public void cleanUpAfterTest(){

        ApiResponse apiResponse = given().contentType("application/json")
                .when().delete("pet/{petId}", actualPet.getId())
                .then().statusCode(200).extract().as(ApiResponse.class);

    }


}