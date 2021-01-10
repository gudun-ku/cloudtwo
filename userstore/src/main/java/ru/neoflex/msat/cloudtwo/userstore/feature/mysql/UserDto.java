package ru.neoflex.msat.cloudtwo.userstore.feature.mysql;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean sex;
    private Date registerDate;
}
