package com.aly.ssm.model;

import java.io.Serializable;

/**
 * Created by lizhen on 2017/7/5.
 */
public class UserDTO implements Serializable {
    private Integer id;
    private Integer userId;
    private String name;
    private Integer age;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, Integer age, Integer state, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.state = state;
    }
}
