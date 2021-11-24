package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public int id;
    public String name;
    public int age;
    public boolean job;

    User() {
    }

    User(String s) {
        List<String> userInfo = new ArrayList<>(Arrays.asList(s.split("\\|")));
        this.id = Integer.parseInt(userInfo.get(0));
        this.name = userInfo.get(1);
        this.age = Integer.parseInt(userInfo.get(2));
        this.job = Boolean.parseBoolean(userInfo.get(3));
    }

    User(int id, String name, int age, boolean job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
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

    public boolean getJob() {
        return job;
    }

    public void setJob(boolean job) {
        this.job = job;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return String.format("%d|%s|%d|%b", this.id, this.name, this.age, this.job);
    }
}
