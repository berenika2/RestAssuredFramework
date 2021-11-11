package com.github.berenika2.restassuredframework.tests.user;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUserTests extends SuiteTestBase {

    private User user;

    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
       UserTestDataGenerator userTestDataGenerator = new UserTestDataGenerator();
       user = userTestDataGenerator.generateUser();

        ApiResponse apiResponse = given().contentType("application/json")
                .body(user)
                .when().post("user")
                .then().statusCode(200).extract().as(ApiResponse.class);

        Assertions.assertThat(user).describedAs("Send User was different than received by API").usingRecursiveComparison().isEqualTo(user);
    }

    @AfterMethod
    public void cleanUpAfterTest(){
        ApiResponse apiResponse = given().contentType("application/json")
                .when().delete("user/{username}", user.getUsername())
                .then().statusCode(200).extract().as(ApiResponse.class);

        Assertions.assertThat(user).describedAs("Send user was different than received by API").usingRecursiveComparison().isEqualTo(user);}

}
