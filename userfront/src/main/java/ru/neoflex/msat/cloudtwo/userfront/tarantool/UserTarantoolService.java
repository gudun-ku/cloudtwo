package ru.neoflex.msat.cloudtwo.userfront.tarantool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.msat.cloudtwo.userfront.domain.User;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserTarantoolService {
    private final UserTarantoolRepository userTarantoolRepository;
    private final UserToUserTarantoolConverter userToUserTarantoolConverter;

    public Optional<UserTarantoolDto> findUserById(Long id) {
        var user = userTarantoolRepository.findById(id);
        return user.map(userToUserTarantoolConverter::convert);
    }


    public List<UserTarantoolDto> getAllUsers() {
        var savedUsers = userTarantoolRepository.findAll();
        return StreamSupport.stream(savedUsers.spliterator(), false)
                .map(userToUserTarantoolConverter::convert)
                .collect(Collectors.toList());

    }

    public List<UserTarantoolDto> searchUser(String firstName) {
        var user = userTarantoolRepository.findByFirstName(firstName);
        return user.stream()
                .map(userToUserTarantoolConverter::convert)
                .collect(Collectors.toList());
    }

    public User insertOne(User user) {
        return userTarantoolRepository.save(user);
    }

    public List<User> insertMany(List<User> users) {
        var savedUsers = userTarantoolRepository.saveAll(users);
        return StreamSupport.stream(savedUsers.spliterator(), false)
                .collect(Collectors.toList());
    }

}
