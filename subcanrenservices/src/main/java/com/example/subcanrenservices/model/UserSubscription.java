package com.example.subcanrenservices.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "user_subscription")
public class UserSubscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long user_id;
    @NotBlank
    private Long sub_id;
    @NotBlank
    private String endsat;
}
