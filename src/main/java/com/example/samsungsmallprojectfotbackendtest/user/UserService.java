package com.example.samsungsmallprojectfotbackendtest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setUserName(createUserDto.getUserName());
        user.setPassword(createUserDto.getPassword());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setTelephone(createUserDto.getTelephone());
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(CreateUserDto createUserDto) {
        Optional<User> userObj = userRepository.findUserByUserNameIs(createUserDto.getUserName());

        if (userObj.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найлен");
        }

        User user = userObj.get();
        user.setUserName(createUserDto.getUserName());
        user.setPassword(createUserDto.getPassword());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setTelephone(createUserDto.getTelephone());
        user.setModifiedAt(LocalDateTime.now());
        return userRepository.saveAndFlush(user);
    }

    public User getUser(Integer userId) {
        Optional<User> userObj = userRepository.findById(userId);
        if (userObj.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найлен");
        }
        return userObj.get();
    }

    public void deleteUser(Integer userId) {
        Optional<User> userObj = userRepository.findById(userId);
        if (userObj.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найлен");
        }
        userRepository.delete(userObj.get());
    }
}
