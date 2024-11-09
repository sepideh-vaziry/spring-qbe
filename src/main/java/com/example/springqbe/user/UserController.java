package com.example.springqbe.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @GetMapping
  public Page<User> getUsersByExample(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email,
      @RequestParam(required = false) String city
  ) {
    UserFilter filter = new UserFilter(name, email, city, page, size);

    return userService.getUsers(filter);
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
