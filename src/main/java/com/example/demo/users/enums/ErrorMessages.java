package com.example.demo.users.enums;

public enum ErrorMessages {
    ACCESS_DENIED("ACCESS_DENIED"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");
    String error;
    ErrorMessages(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
