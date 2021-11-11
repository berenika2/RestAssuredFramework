package com.github.berenika2.restassuredframework.tests.pet;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.pet.Pet;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import org.assertj.core.api.Assertions;
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
        pet.setName("Diego");
        Assertions.assertThat(actualPet).describedAs("Send Pet was different than received by API").usingRecursiveComparison().isEqualTo(pet);
    }

    @AfterMethod
    public void cleanUpAfterTest(){

        ApiResponse apiResponse = given().contentType("application/json")
                .when().delete("pet/{petId}", actualPet.getId())
                .then().statusCode(200).extract().as(ApiResponse.class);

        ApiResponse expectedApiResponse = new ApiResponse();
        expectedApiResponse.setCode(200);
        expectedApiResponse.setType("unknown");
        expectedApiResponse.setMessage(actualPet.getId().toString());

        Assertions.assertThat(apiResponse).describedAs("API Response from system was not as expected").usingRecursiveComparison().isEqualTo(expectedApiResponse);
    }


}