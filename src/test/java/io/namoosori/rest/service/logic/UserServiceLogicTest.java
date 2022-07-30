package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceLogicTest {

    private User kim;
    private User lee;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void StartUp() {
        kim = new User("Kim", "kim@..com");
        lee = new User("lee", "lee@..com");
        userService.register(kim);
        userService.register(lee);
    }
    @AfterEach
    public void cleanUp() {
        userService.remote(kim.getId());//지금 보니 까 왜 remote라고 했ㅈ지??
        userService.remote(lee.getId());

    }

    @Test
    void register() {

        User sample = User.sample();
        this.userService.register(sample);
        assertThat(userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
    }

    @Test
    void modify() {
    }

    @Test
    void remote() {
    }

    @Test
    void find() {
        assertThat(userService.find(lee.getId())).isNotNull();
        assertThat(userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());

    }

    @Test
    void findAll() {
    }
}