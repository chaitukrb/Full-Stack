package com.example.mailservice.user.repository;

import com.example.mailservice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //get emails of all users who are subscribed to subscription sid
    @Query(value = "select email from user where id=?", nativeQuery = true)
    String getEmails(Long sid);
}
