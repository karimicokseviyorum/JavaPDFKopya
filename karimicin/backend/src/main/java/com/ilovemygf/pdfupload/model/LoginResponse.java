package com.ilovemygf.pdfupload.model;

public class LoginResponse {


    private String token;  // Kullanıcının oturum açması için gerekli token

    public LoginResponse() {}

    public LoginResponse(String token) {
        this.token = token;
    }

    // Getter ve Setter
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}