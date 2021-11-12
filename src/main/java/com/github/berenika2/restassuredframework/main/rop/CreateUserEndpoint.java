package com.github.berenika2.restassuredframework.main.rop;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import com.github.berenika2.restassuredframework.main.request.configuration.RequestConfigurationBuilder;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class CreateUserEndpoint extends BaseEndpoint<CreateUserEndpoint, ApiResponse>{

    private User user;

    @Override
    protected Type getModelType() {
        return ApiResponse.class;
    }

    @Override
    public CreateUserEndpoint sendRequest() {
        response = given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification())
                .body(user)
                .when().post("user");
               return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    public CreateUserEndpoint setUser(User user) {
        this.user = user;
        return this;
    }
}
