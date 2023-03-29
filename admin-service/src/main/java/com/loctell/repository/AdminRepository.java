package com.loctell.repository;

import com.loctell.modules.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("select u from Admin u where u.email=:email")
    public Admin getUserByMail(@Param("email") String email);

    @Query("SELECT u FROM Admin u WHERE u.email = :email AND u.password = :password")
    public Admin findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);
}
