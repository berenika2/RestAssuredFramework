package com.github.berenika2.restassuredframework.tests.user;

import com.github.berenika2.restassuredframework.main.pojo.ApiResponse;
import com.github.berenika2.restassuredframework.tests.testbases.SuiteTestBase;
import org.testng.annotations.Test;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUserTests extends SuiteTestBase {
    @Test
    public void givenUserWhenPostUserThenUserIsCreatedTest() {
        User user = new User();
        user.setId(445);
        user.setUsername("berenika22");
        user.setFirstName("Berenika");
        user.setLastName("Maria");
        user.setEmail("berenika@test.com");
        user.setPassword("password");
        user.setPhone("+123456789");
        user.setUserStatus(123);

        ApiResponse apiResponse = given().contentType("application/json")
                .body(user)
                .when().post("user")
                .then().statusCode(200).extract().as(ApiResponse.class);

        assertEquals(apiResponse.getCode(), Integer.valueOf(200), "Code");
        assertEquals(apiResponse.getType(), "unknown", "Type");
        assertEquals(apiResponse.getMessage(), "445", "Message");
    }

}
