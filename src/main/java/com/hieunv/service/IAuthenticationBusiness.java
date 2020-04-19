package com.hieunv.service;

import com.hieunv.common.request.LoginRequest;
import com.hieunv.common.dto.WebLoginResponse;
import com.hieunv.common.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationBusiness {
    /**
     * @param loginRequest
     * @param request
     * @return
     */
    WebLoginResponse webAuthen(LoginRequest loginRequest, HttpServletRequest request) throws BusinessException;

//    /**
//     * @param username
//     * @param request
//     * @return
//     */
//    void forgotPassword(String username, String reCaptcha, HttpServletRequest request) throws BusinessException, MessagingException;
//
//    void forgotPassword(String username, HttpServletRequest request);
//
//    /**
//     * @param changePasswordRequest
//     * @param request
//     */
//    void changePassword(ChangePasswordRequest changePasswordRequest, HttpServletRequest request)
//            throws BusinessException;
//
//    /**
//     * @param request
//     */
//    void logout(HttpServletRequest request);

}
