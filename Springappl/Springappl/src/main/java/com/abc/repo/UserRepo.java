package com.abc.repo;

import com.abc.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserDtls,Integer> {



    @Query("SELECT p FROM UserDtls p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.address) LIKE %?1%")
    List<UserDtls> searchUserDetails(String query);


}
