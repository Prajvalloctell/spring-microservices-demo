package com.loctell.repository;

import com.loctell.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email=:email")
    public User getUserByMail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    public User findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);
}
