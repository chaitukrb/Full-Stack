package com.example.zuulgateway;

public class UserId {
    static Long id;

    public UserId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
