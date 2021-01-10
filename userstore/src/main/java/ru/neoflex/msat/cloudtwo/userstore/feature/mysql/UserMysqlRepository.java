package ru.neoflex.msat.cloudtwo.userstore.feature.mysql;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.msat.cloudtwo.userstore.domain.User;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface UserMysqlRepository extends CrudRepository<User, Long> {
    User getByLogin(String login);

    User getById(Long id);

    List<User> findAll();

    @Query(value= "SELECT * FROM user WHERE first_name like ?1 and last_name like ?2" +
            " LIMIT 10")
    List<User> getByFirstNameAndLastName(String firstName, String lastName);
}
