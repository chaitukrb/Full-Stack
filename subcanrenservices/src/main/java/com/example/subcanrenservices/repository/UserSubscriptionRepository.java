package com.example.subcanrenservices.repository;

import com.example.subcanrenservices.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_subscription (user_id,sub_id,endsat) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public void Subscribe(Long uid, Long sid, String date);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user_subscription WHERE user_id=?1 and sub_id=?2", nativeQuery = true)
    public void UnSubscribe(Long uid, Long sid);

    @Transactional
    @Modifying
    @Query(value = "update user_subscription SET endsat=?3 where user_id=?1 and sub_id=?2", nativeQuery = true)
    public void Renewal(Long uid, Long sid, String date);

    @Transactional
    @Query(value = "select endsat from user_subscription where user_id=?1 and sub_id=?2", nativeQuery = true)
    public String getSubEndDate(Long uid, Long sid);

    @Transactional
    @Query(value = "select sub_id from user_subscription where user_id=?",nativeQuery = true)
    public List<Long> UserSubs(Long uid);

}
