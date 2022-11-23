package com.abc.repo;

import com.abc.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<UserCredentials,Integer> {
    UserCredentials findByUsername(String username);
}
