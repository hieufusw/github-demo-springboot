package com.hieunv.service.impl;

import com.hieunv.common.exception.BusinessException;
import com.hieunv.common.exception.ExceptionCode;
import com.hieunv.common.request.LoginRequest;
import com.hieunv.dto.WebLoginResponse;
import com.hieunv.repository.UserRepository;
import com.hieunv.service.IAuthenticationBusiness;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationBusiness implements IAuthenticationBusiness {

    @Autowired
    private UserRepository userRepository;


    @Override
    public WebLoginResponse webAuthen(LoginRequest loginRequest, HttpServletRequest request) throws BusinessException {
        String userName = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String clientIp = request.getRemoteAddr();
        if ("".equals(userName) || "".equals(password)) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID,
                    "UserName or Password invalid. please check again!");
        }

        return null;
    }
}
