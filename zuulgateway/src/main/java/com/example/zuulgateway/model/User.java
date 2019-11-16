package com.example.zuulgateway.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;


//    @ManyToMany(fetch = FetchType.LAZY,
//        cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//        })
//    @JoinTable(name = "user_subscriptions",
//    joinColumns = { @JoinColumn(name = "user_id")},
//    inverseJoinColumns = { @JoinColumn(name = "subscription_id")})
//    private Set<Subscription> subscriptions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User( String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Subscription> getSubscriptions() {
//        return subscriptions;
//    }
//
//    public void setSubscriptions(Set<Subscription> subscriptions) {
//        this.subscriptions = subscriptions;
//    }

    public Set<Role> getRoles() {
        return roles;
    }
}
