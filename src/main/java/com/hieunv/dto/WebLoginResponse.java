package com.hieunv.dto;

import java.util.List;

public class WebLoginResponse {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private List<String> listRoleCode;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getListRoleCode() {
        return listRoleCode;
    }

    public void setListRoleCode(List<String> listRoleCode) {
        this.listRoleCode = listRoleCode;
    }
}
