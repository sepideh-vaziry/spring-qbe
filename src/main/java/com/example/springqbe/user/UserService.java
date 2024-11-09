package com.example.springqbe.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(UserFilter filter) {

        User probe = User.builder()
            .name(filter.name())
            .email(filter.email())
            .city(filter.city())
            .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()                        // Ignore null fields
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()) // Partial match and case-insensitive for name
            .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())   // Partial match and case-insensitive for email
            .withMatcher("city", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase());   // Exact match, case-insensitive for city

        // Create an Example instance with the probe and matcher
        Example<User> example = Example.of(probe, matcher);

        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(filter.page(), filter.size(), sort);

        // Query by example with the complex matcher
        return userRepository.findAll(example, pageable);
    }

    public User create(String name, String email, String city) {
        User user = User.builder()
            .name(name)
            .email(email)
            .city(city)
            .build();

        return userRepository.save(user);
    }

}
