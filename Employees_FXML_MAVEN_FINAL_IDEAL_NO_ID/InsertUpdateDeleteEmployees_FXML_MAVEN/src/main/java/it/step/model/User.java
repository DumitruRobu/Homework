package it.step.model;

import java.time.LocalDate;

public class User {
    private String first_name;
    private String second_name;
    private String username;
    private String password;

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User (String first_name, String second_name, String username, String password){
        this.first_name = first_name;
        this.second_name = second_name;
        this.username = username;
        this.password = password;
    }

    public User (String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username + password;
    }
}
