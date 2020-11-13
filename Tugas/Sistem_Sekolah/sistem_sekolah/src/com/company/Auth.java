package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Auth {
    public String username;
    protected String password;

    static ArrayList<Auth> Database = new ArrayList<>();

    public Auth(String username, String password) {
        this.username   = username;
        this.password   = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void save(String username, String password) {
        Database.add(new Auth(username, password));
    }

    public boolean login(String username, String password) {
        for(int i = 0; i < Database.size(); i++) {
            if(Database.get(i).getUsername().equals(username) && Database.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}