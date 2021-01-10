package ru.neoflex.msat.cloudtwo.userfront.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.msat.cloudtwo.userfront.tarantool.UserTarantoolDto;
import ru.neoflex.msat.cloudtwo.userfront.tarantool.UserTarantoolService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserTarantoolService userSearchService;

    @GetMapping("/search")
    public List<UserTarantoolDto> getUser(@RequestParam("firstName") String firstName) {
        List<UserTarantoolDto> users = userSearchService.searchUser(firstName);
        return users;
    }

    @GetMapping
    public List<UserTarantoolDto> getAllUsers() {
        return userSearchService.getAllUsers();
    }

}
