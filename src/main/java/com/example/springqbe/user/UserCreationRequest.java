package com.example.springqbe.user;

public record UserCreationRequest(
    String name,
    String email,
    String city
) {
}
