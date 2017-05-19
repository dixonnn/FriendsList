package com.example.chris.friendslist;

/**
 * Created by chris on 5/18/17.
 */

public class Friend {

    private String firstName, lastName, hometown;
    private int age;

    public Friend(String firstName, String lastName, String hometown, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = hometown;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHometown() {
        return hometown;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
