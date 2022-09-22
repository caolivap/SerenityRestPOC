package com.carlos.automation.models;


public class User {

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;

    public User(String title, String firstName, String lastName, String email) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String id, String title, String firstName, String lastName, String email) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
