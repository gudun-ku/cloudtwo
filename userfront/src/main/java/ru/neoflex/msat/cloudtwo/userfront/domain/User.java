package ru.neoflex.msat.cloudtwo.userfront.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
      private String firstName;

    @Size(max = 50)
    private String lastName;

    private Integer age;

    private Boolean sex;

    private Date registerDate;
}
