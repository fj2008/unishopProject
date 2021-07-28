package com.example.demo.domian.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT id,username,address,email,null password FROM user WHERE username=:username AND password=:password", nativeQuery = true)
    User mLogin(String username, String password);

}
