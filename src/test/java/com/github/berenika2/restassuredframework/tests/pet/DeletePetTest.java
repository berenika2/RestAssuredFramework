package com.github.berenika2.restassuredframework.tests.pet;


import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class DeletePetTest extends SuiteTestBase{


    @Description("Delete not existing pet - 404 status")
    @Test
    public void givenNonExistingPetWhenDeletingPetThenPetNotFoundTest(){

        int nonExistingPetId = new Faker().number().numberBetween(1000, 10000);




    }
}
