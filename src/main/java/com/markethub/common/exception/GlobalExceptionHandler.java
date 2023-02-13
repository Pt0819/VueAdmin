package com.markethub.common.exception;

import com.markethub.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peter Huang
 * controller异常类
 * @date 2023/2/6 19:49
 **/
@Slf4j
@RestController
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) {
        return Result.fail(e.getMessage());
    }

}
