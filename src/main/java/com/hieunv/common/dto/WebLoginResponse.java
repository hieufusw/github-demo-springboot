package com.hieunv.common.dto;

import java.util.List;

public class WebLoginResponse {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;

    public WebLoginResponse(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
