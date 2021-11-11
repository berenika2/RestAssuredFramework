package com.github.berenika2.restassuredframework.tests.user;
import com.github.berenika2.restassuredframework.main.pojo.user.User;
import com.github.berenika2.restassuredframework.main.test.data.TestDataGenerator;

public class UserTestDataGenerator extends TestDataGenerator {
    public User generateUser(){
        User user = new User();
        user.setId(faker().number().numberBetween(1, 9999));
        user.setUsername(faker().name().username());
        user.setFirstName(faker().name().firstName());
        user.setLastName(faker().name().lastName());
        user.setEmail(faker().internet().emailAddress());
        user.setPassword("P@ssw0rd");
        user.setPhone(faker().phoneNumber().phoneNumber());
        user.setUserStatus(1);
        return user;
    }
}
