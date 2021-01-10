package ru.neoflex.msat.cloudtwo.userstore.feature.mysql;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.neoflex.msat.cloudtwo.userstore.domain.User;

@Component
public class UserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return new UserDto()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAge(user.getAge())
                .setSex(user.getSex())
                .setRegisterDate(user.getRegisterDate());
    }
}
