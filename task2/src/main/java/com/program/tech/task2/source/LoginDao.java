package com.program.tech.task2.source;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginDao extends CrudRepository<User, Long> {
    Optional<User> findByPasswordAndLogin(String password, String login);
}
