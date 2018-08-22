package com.shit.demo.bean;

import net.sf.json.JSONObject;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class User {
    @Max(value=30,message = "超过最大数值")
    @Min(value=1,message = "小于最小数值")
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(@Max(value = 30, message = "超过最大数值") @Min(value = 1, message = "小于最小数值") int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return JSONObject.fromObject(this).toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
