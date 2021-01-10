package ru.neoflex.msat.cloudtwo.userfront.tarantool;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.tarantool.repository.Query;
import ru.neoflex.msat.cloudtwo.userfront.domain.User;

import java.util.List;

public interface UserTarantoolRepository extends CrudRepository<User, Long> {
    @Query(function = "find_by_first_name")
    List<User> findByFirstName(String firstName);
}
