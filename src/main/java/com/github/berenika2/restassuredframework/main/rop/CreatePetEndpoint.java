package com.github.berenika2.restassuredframework.main.rop;

import com.github.berenika2.restassuredframework.main.pojo.pet.Pet;
import com.github.berenika2.restassuredframework.main.request.configuration.RequestConfigurationBuilder;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class CreatePetEndpoint extends BaseEndpoint<CreatePetEndpoint, Pet>{

    private Pet pet;

    @Override
    protected Type getModelType() {
        return Pet.class;
    }

    @Override
    public CreatePetEndpoint sendRequest() {
        response = given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification()).body(pet)
                .when().post("pet");
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    public CreatePetEndpoint setPet(Pet pet) {
        this.pet = pet;
        return this;
    }
}
