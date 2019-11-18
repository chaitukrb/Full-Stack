package com.example.mailservice.usersub.repository;

import com.example.mailservice.model.usersubscription.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    //get users who are subscribed for subscription sid
    @Query(value = "select user_id from user_subscription where sub_id=?", nativeQuery = true)
    List<Long> getSubscribedUsers(Long sid);
}
