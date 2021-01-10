package ru.neoflex.msat.cloudtwo.userstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.msat.cloudtwo.userstore.domain.User;
import ru.neoflex.msat.cloudtwo.userstore.feature.mysql.UserDto;
import ru.neoflex.msat.cloudtwo.userstore.feature.mysql.UserMysqlService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserMysqlService userService;

    @PostMapping("/reg")
    public UserDto createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public UserDto deleteUser(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

}
