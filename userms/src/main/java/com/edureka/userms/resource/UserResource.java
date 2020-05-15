package com.edureka.userms.resource;

import com.edureka.userms.model.User;
import com.edureka.userms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        LOGGER.info("************* getting all users ********");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getSingleUser(@PathVariable String userId) {
        LOGGER.info("************* getting all users ********");
        final User singleUser = userService.getSingleUser(Long.parseLong(userId));
        if (null == singleUser) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(singleUser);
    }

    @GetMapping("/orders")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok(userService.getAllOrders());
    }
}
