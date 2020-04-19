package com.hieunv.service.impl;

import com.hieunv.common.enums.Status;
import com.hieunv.common.exception.BusinessException;
import com.hieunv.common.exception.ExceptionCode;
import com.hieunv.common.request.LoginRequest;
import com.hieunv.common.dto.WebLoginResponse;
import com.hieunv.entity.UserEntity;
import com.hieunv.repository.UserRepository;
import com.hieunv.service.IAuthenticationBusiness;
import com.hieunv.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationBusiness implements IAuthenticationBusiness {

    @Autowired
    private IUserService userService;


    @Override
    public WebLoginResponse webAuthen(LoginRequest loginRequest, HttpServletRequest request) throws BusinessException {
        String userName = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String clientIp = request.getRemoteAddr();
        if ("".equals(userName) || "".equals(password)) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID,
                    "UserName or Password invalid. please check again!");
        }
        UserEntity user = userService.findByUserName(userName);
        if (user == null) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID,
                    "UserName or Password invalid. please check again!");
        }

        if (Status.INACTIVE.equals(user.getStatus())) {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_INACTIVE,
                    "UserName is inactive. please check again!");
        }
        Long numberLoginFail = user.getNumberLoginFail();
        numberLoginFail += 1;
        //userService.updateNumberTimesLoginFail(request, user, numberLoginFail);
        throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID,
                "UserName or Password invalid. please check again!");
    }

}
