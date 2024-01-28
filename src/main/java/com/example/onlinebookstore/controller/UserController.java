package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.servce.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Get all available users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/by-email")
    @Operation(summary = "Get user by email", description = "Get user by email")
    public UserDto getByEmail(String email) {
        return userService.findByEmail(email);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id", description = "Safe delete user by id")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}