package main.java.model;

import main.java.dictionaries.Gender;

public class User {
    private String firstName;
    private String surName;
    private String email;
    private String password;
    private Integer birthYear;
    private Gender gender;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public User setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public User setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getUserInitial() {
        StringBuilder result = new StringBuilder();
        if (firstName != null) {
            result.append(firstName);
        }
        if (result.length() != 0) {
            result.append(" ");
        }
        if (surName != null) {
            result.append(surName);
        }
        return result.toString();
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
