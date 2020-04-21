package com.hieunv.service.impl;

import com.hieunv.common.exception.BusinessException;
import com.hieunv.common.exception.ExceptionCode;
import com.hieunv.common.request.LoginRequest;
import com.hieunv.common.dto.WebLoginResponse;
import com.hieunv.entity.UserEntity;
import com.hieunv.repository.UserRepository;
import com.hieunv.service.IAuthenticationBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationBusiness implements IAuthenticationBusiness {

    @Autowired
    private UserRepository userRepository;


    @Override
    public WebLoginResponse webAuthen(LoginRequest loginRequest, HttpServletRequest request) throws BusinessException {
        String userName = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        if ("".equals(userName) || "".equals(password)) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID);
        }
        UserEntity user = userRepository.findByUserName(loginRequest.getUsername());
        if (user == null) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID);
        }
        WebLoginResponse response = new WebLoginResponse(user.getUserName(),user.getPassword());
        return response;
    }
}
