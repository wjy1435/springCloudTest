package com.example.demo.entity;
//
//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity(name="ay_user")
public class AyUser implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
//    @GeneratedValue
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="name",length=20)
    private String name;
    @Column(name="password",length=20)
    private String password;

    public String getPrems() {
        return prems;
    }

    public void setPrems(String prems) {
        this.prems = prems;
    }
    @Column(name="prems",length=20)
    private String prems;//具备权限

}
