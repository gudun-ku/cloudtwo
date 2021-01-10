package ru.neoflex.msat.cloudtwo.userstore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@Table("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    //@JsonIgnore
    @NotNull
    @Column("password_hash")
    private String password;

    @Size(max = 50)
    @Column("first_name")
    private String firstName;

    @Size(max = 50)
    @Column("last_name")
    private String lastName;

    @Column("age")
    private Integer age;

    @Column("sex")
    private Boolean sex;


    @Column("register_date")
    private Date registerDate;
}
