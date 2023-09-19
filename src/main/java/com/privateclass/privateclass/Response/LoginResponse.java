package com.privateclass.privateclass.Response;

import lombok.Data;
// we don't need this
@Data
public class LoginResponse {
    String message;
    Boolean status;

    public LoginResponse() {
    }
    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
