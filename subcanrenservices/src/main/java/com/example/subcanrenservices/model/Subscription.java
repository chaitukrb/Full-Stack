package com.example.subcanrenservices.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Subscription implements Serializable {

    private Long id;

    private String title;

    private Long price;

    private Long duration;

    public Subscription() {

    }
    public Subscription(Long id,String title,Long price, Long duration) {
        this.id=id;
        this.title=title;
        this.price=price;
        this.duration=duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}