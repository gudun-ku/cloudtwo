package ru.neoflex.msat.cloudtwo.userfront.tarantool;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserTarantoolDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
}
