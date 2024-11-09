package com.example.springqbe.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsersByExample(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email,
      @RequestParam(required = false) String city
  ) {
    return userService.getUsers(name, email, city);
  }

  @PostMapping
  public ResponseEntity<User> create(
      @RequestBody UserCreationRequest request
  ) {
    User user = userService.create(
        request.name(),
        request.email(),
        request.city()
    );

    return ResponseEntity.ok(user);
  }

}
