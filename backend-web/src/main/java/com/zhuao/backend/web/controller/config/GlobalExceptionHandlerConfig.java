package com.zhuao.backend.web.controller.config;


import base.ResponseVO;
import com.alibaba.fastjson.JSONObject;
import exception.BackendException;
import exception.BackendExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static exception.BackendExceptionType.PARAMETER_VERIFY_FAILURE;


/**
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerConfig {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO<Object> errorHandler(HttpServletRequest req, Exception e) {
        log.error("Message: {}\nException: {}.", e.getMessage(), ExceptionUtils.getStackTrace(e));
        if (e instanceof BackendException) {
            BackendExceptionType backendExceptionType =((BackendException) e).getExceptionType();
            if(!ObjectUtils.isEmpty(backendExceptionType)){
                return ResponseVO.builder()
                        .code(backendExceptionType.getCode())
                        .message(backendExceptionType.getMessage())
                        .build();
            }else {
                return ResponseVO.builder()
                        .code(BackendExceptionType.UNKNOWN_ERROR.getCode())
                        .message(e.getMessage())
                        .build();
            }
        }

        try {
            // 解析其他服务异常信息
            JSONObject jsonObject = (JSONObject) JSONObject.parse(e.getMessage());
            if (jsonObject.containsKey("errorCode")) {
                // 内部服务已知异常
                return ResponseVO.builder()
                        .code(jsonObject.getIntValue("errorCode"))
                        .message(jsonObject.getString("message"))
                        .build();
            }
        } catch (Exception ignore) {
            // 当前服务底层异常
            log.info("errorHandler::serviceErrorMessage={}", e.getMessage());
        }

        return ResponseVO.builder()
                .code(500)
                .message("服务异常")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVO<Object> handleMethodArgumentNotValidExp(MethodArgumentNotValidException e) {
        FieldError error = (FieldError) e.getBindingResult().getAllErrors().get(0);
        String errorMsg = error.getField() + "(" + error.getRejectedValue() + ")" +
                " : " + error.getDefaultMessage();
        log.error("MethodArgumentNotValid Exception::{}", errorMsg);
        return ResponseVO.builder()
                .code(PARAMETER_VERIFY_FAILURE.getCode())
                .message(errorMsg)
                .build();
    }

}
