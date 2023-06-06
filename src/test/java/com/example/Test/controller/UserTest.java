package com.example.Test.controller;

import com.example.Test.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest {
    @Autowired
    private UserController userController;

    @Test
    public void testGetListUsers() {
        List<User> users = userController.getListUser();

    }
}