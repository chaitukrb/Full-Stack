package com.example.subcanrenservices.model;

import java.util.ArrayList;
import java.util.List;

public class wrapperclass {
    private List<Subscription> subscriptions;

    public wrapperclass() {
        subscriptions = new ArrayList<>();
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
