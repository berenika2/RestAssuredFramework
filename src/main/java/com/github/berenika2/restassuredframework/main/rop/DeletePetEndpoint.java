package com.github.berenika2.restassuredframework.main.rop;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.request.configuration.RequestConfigurationBuilder;
import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class DeletePetEndpoint extends BaseEndpoint<DeletePetEndpoint, ApiResponse>{

    private int nonExistingPetId;

    @Override
    protected Type getModelType() {
        return ApiResponse.class;
    }

    @Override
    public DeletePetEndpoint sendRequest() {


        response = given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification())
                .when().delete("pet/{petId}", nonExistingPetId);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    public DeletePetEndpoint setPetId(Integer nonExistingPetId){
        this.nonExistingPetId = nonExistingPetId;
        return this;
    }
}
