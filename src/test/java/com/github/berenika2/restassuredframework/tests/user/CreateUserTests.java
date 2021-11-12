package com.github.berenika2.restassuredframework.tests.user;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import com.github.berenika2.restassuredframework.main.request.configuration.RequestConfigurationBuilder;
import com.github.berenika2.restassuredframework.main.rop.CreateUserEndpoint;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests extends SuiteTestBase {

    private User user;

    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
        UserTestDataGenerator userTestDataGenerator = new UserTestDataGenerator();
        user = userTestDataGenerator.generateUser();

        ApiResponse apiResponse = new CreateUserEndpoint().setUser(user).sendRequest().assertRequestSuccess().getResponseModel();

        ApiResponse expectedApiResponse = new ApiResponse();
        expectedApiResponse.setCode(HttpStatus.SC_OK);
        expectedApiResponse.setType("unknown");
        expectedApiResponse.setMessage(user.getId().toString());

        Assertions.assertThat(apiResponse).describedAs("Created User was not created by API").usingRecursiveComparison().isEqualTo(expectedApiResponse);
    }

    @AfterMethod
    public void cleanUpAfterTest(){
        ApiResponse apiResponse = given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification())
                .when().delete("user/{username}", user.getUsername())
                .then().statusCode(HttpStatus.SC_OK).extract().as(ApiResponse.class);

        ApiResponse expectedApiResponse = new ApiResponse();
        expectedApiResponse.setCode(HttpStatus.SC_OK);
        expectedApiResponse.setType("unknown");
        expectedApiResponse.setMessage(user.getUsername());

        Assertions.assertThat(user).describedAs("Send user was different than received by API").usingRecursiveComparison().isEqualTo(user);}

}
