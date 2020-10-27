package com.foneom.tracker;

import java.util.UUID;

public class Item {
    private String id;
    private String name;

    public Item() {
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    public Item(String name) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
