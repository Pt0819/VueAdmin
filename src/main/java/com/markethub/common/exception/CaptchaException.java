package com.markethub.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Peter Huang
 * @date 2023/2/7 16:03
 **/
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }

}
