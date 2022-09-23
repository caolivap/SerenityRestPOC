package com.carlos.automation.models.builder;

import com.carlos.automation.models.User;

public class UserBuilder {

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;

    public UserBuilder() {
        this.id = "";
        this.title = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public static UserBuilder with() {
        return new UserBuilder();
    }

    public UserBuilder theId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder theTitle(String title) {
        this.title = title;
        return this;
    }

    public UserBuilder theFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder theLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder andEmail(String email) {
        this.email = email;
        return this;
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

    public User build() {
        return new User(this);
    }
}
