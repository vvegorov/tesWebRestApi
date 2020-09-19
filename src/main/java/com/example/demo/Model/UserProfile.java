package com.example.demo.Model;

/**
 * Created by lubov on 07.09.20.
 */
public class UserProfile {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfile [name=" + name + ", email=" + email + "]";
    }

}
