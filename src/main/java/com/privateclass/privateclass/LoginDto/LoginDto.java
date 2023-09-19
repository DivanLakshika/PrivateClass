package com.privateclass.privateclass.LoginDto;
// we need this because request is coming from user, only have email and password.
public class LoginDto {
    private String email;
    private String password1;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password1;
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password1 = password1;
    }

    public LoginDto() {
    }
}