package ru.neoflex.msat.cloudtwo.userfront.tarantool;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.neoflex.msat.cloudtwo.userfront.domain.User;


@Component
public class UserToUserTarantoolConverter implements Converter<User, UserTarantoolDto> {

    @Override
    public UserTarantoolDto convert(User user) {
        return new UserTarantoolDto()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());
    }
}
