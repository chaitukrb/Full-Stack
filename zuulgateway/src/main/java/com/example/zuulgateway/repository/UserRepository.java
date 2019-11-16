package com.example.zuulgateway.repository;

import com.example.zuulgateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT into user_subscriptions (user_id, subscription_id, dos) select u.id,s.id,?3 from user u,subscription s where u.username=?1 and s.name=?2", nativeQuery = true)
    public void Subscribe(String u_name, String s_name, String date);

    @Transactional
    @Modifying
    @Query(value = "delete from user_subscriptions where user_id=?1 and subscription_id=(select id from subscription where name=?2)", nativeQuery = true)
    public void CancelSub(Long uid, String s_name);

    @Transactional
    @Modifying
    @Query(value = "update user_subscriptions SET dos=?3 where user_id=?1 and subscription_id=(select id from subscription where name=?2)", nativeQuery = true)
    public void RenSub(Long uid, String s_name, String date);

    @Transactional
    @Query(value = "select dos from user_subscriptions where user_id=?1 and subscription_id=(select id from subscription where name=?2)", nativeQuery = true)
    public String getSubEndDate(Long uid, String s_name);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
