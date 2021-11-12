package com.github.berenika2.restassuredframework.main.request.configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class RequestConfigurationBuilder {
    public RequestSpecBuilder getRequestSpecBuilder(){
        return new RequestSpecBuilder()
                .setConfig(RestAssuredConfig.config().objectMapperConfig(ObjectMapperConfig.objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON)))
                .setContentType(ContentType.JSON);

    }

    public static RequestSpecification getDefaultRequestSpecification(){
    return new RequestConfigurationBuilder().getRequestSpecBuilder().build();
    }
}
