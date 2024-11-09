package com.example.springqbe.user;

public record UserFilter(
    String name,
    String email,
    String city,
    int page,
    int size
) {
}
