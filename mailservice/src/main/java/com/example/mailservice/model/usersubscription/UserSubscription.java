package com.example.mailservice.model.usersubscription;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_subscription")
public class UserSubscription {
    @Id
    private Long id;
    private Long user_id;
    private Long sub_id;
    private String endsat;
}
