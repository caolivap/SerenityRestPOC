package com.carlos.automation.models;


import com.carlos.automation.models.builder.UserBuilder;

public class User {

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.getId();
        this.title = userBuilder.getTitle();
        this.firstName = userBuilder.getFirstName();
        this.lastName = userBuilder.getLastName();
        this.email = userBuilder.getEmail();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        User auxUser = (User)obj;
        return this.title.equals(auxUser.getTitle())
                && this.firstName.equals(auxUser.getFirstName())
                && this.lastName.equals(auxUser.getLastName())
                && this.email.equals(auxUser.getEmail());
    }
}
