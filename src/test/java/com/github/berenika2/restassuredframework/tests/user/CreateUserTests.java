package com.github.berenika2.restassuredframework.tests.user;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import com.github.berenika2.restassuredframework.tests.user.UserTestDataGenerator;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
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

        assertEquals(apiResponse.getCode(), Integer.valueOf(200), "Code");
        assertEquals(apiResponse.getType(), "unknown", "Type");
        assertEquals(apiResponse.getMessage(), user.getId().toString(), "Message");
    }

    @AfterMethod
    public void cleanUpAfterTest(){
        ApiResponse apiResponse = given().contentType("application/json")
                .when().delete("user/{username}", user.getUsername()) // Usuwamy użytkownika z podanym username
                .then().statusCode(200).extract().as(ApiResponse.class);

        assertEquals(apiResponse.getCode(), Integer.valueOf(200), "Code");
        assertEquals(apiResponse.getType(), "unknown", "Type");
        assertEquals(apiResponse.getMessage(), user.getUsername(), "Message"); // Sprawdzamy, czy w odpowiedzi systemu znajduje się usunięte username użytkownika
    }

}
