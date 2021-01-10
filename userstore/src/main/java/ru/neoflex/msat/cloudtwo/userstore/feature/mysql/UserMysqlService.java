package ru.neoflex.msat.cloudtwo.userstore.feature.mysql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.msat.cloudtwo.userstore.domain.User;
import ru.neoflex.msat.cloudtwo.userstore.utils.PasswordUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMysqlService {

    private final UserMysqlRepository userMysqlRepository;
    private final UserDtoConverter userDtoConverter;

    @Transactional
    public UserDto save(User user) {
        String password = user.getPassword();
        if (password != null) {
            String securePassword = PasswordUtils.generateSecurePassword(password, PasswordUtils.getSalt(5));
            user.setPassword(securePassword);
        }
        final Long isNew = user.getId();
        User savedUser = userMysqlRepository.save(user);
        if (isNew == null) {
            user.setRegisterDate(new Date());
        }
        return this.convert(savedUser);
    }

    public List<UserDto> getAllUsers() {
        return userMysqlRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public UserDto getUser(Long id) {
        return convert(userMysqlRepository.getById(id));
    }

    public UserDto convert(User user) {
        return userDtoConverter.convert(user);
    }
}
