package com.example.quanlytaikhoanthanhtoansinhvien.Login;

public class LoginModel {
    String Username;
    String password;

    public LoginModel(){}
    public LoginModel(String username, String password) {
        Username = username;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginModel{" +
                "Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}