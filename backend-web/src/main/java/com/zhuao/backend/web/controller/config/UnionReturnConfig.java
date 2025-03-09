package com.zhuao.backend.web.controller.config;

import annotation.IgnoreResult;
import base.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * author: zhn4528
 * create: 2022/4/21 16:55
*/
@Slf4j
@EnableWebMvc
@Configuration
public class UnionReturnConfig {

    @RestControllerAdvice("com.zhuao.backend.web.controller.web")
    static class UnionResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(
                MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass
        ) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(
                Object body, MethodParameter methodParameter, MediaType mediaType,
                Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                ServerHttpResponse serverHttpResponse
        ) {
            IgnoreResult ignoreResult = AnnotationUtils.findAnnotation(methodParameter.getAnnotatedElement(), IgnoreResult.class);
            Object result;
            if(!ObjectUtils.isEmpty(ignoreResult)){
                return body;
            }
            if (body instanceof ResponseVO) {
                result = body;
            } else {
                result = ResponseVO.builder().result(body).build();
            }
            return result;
        }
    }
}
