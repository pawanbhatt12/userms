package com.edureka.userms.service;

import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.info("#### GETTING ALL USERS ####");
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(Long userId) {
        LOGGER.info("#### GETTING SINGLE USERS: {} ####", userId);
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void createUser(User user) {
        // Please implement
    }

    @Override
    public void deleteUser(Long userId) {
// Please implement
    }

    @Override
    public void updateUser(User user) {
// Please implement
    }

    @Override
    public Object getAllOrders() {
        return restTemplate.getForObject("http://orderms/orders", Object.class);
    }
}
