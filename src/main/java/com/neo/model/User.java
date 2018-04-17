package com.neo.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@javax.persistence.Entity
@DynamicUpdate
@Data//避免重复写get和set，tostring
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private int age;
}