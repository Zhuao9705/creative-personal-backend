package com.zhuao.backend.web.controller.aspect;


import com.alibaba.fastjson.JSON;
import com.zhuao.backend.web.controller.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请求日志信息记录
 * author: zhuao
 */
@Slf4j
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 3)
public class RequestLogAspect {

    @Pointcut(value = "execution(* com.zhuao.backend.web.controller..*.*(..)) "
            // 移除探活接口
            + "&& !execution(* com.zhuao.backend.web.controller.health.HealthCheckController.*(..))"
    )
    public void logAspect() {
    }

    @Before("logAspect()")
    public void before(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("RequestIP: {}\nMethod: {}\nURL: {}\nRequestParam: {}\nRequestBody: {}",
                request.getLocalAddr(), request.getMethod(), request.getRequestURL().toString(),
                getRequestParams(request), JSON.toJSONString(Arrays.toString(jp.getArgs()))
        );
    }

    public String getRequestParams(HttpServletRequest request) {
        StringBuffer requestParams = new StringBuffer();
        Map<String, String[]> paramMap = request.getParameterMap();
        paramMap.forEach((name, valueArray) -> {
            requestParams.append(name);
            requestParams.append("=");
            requestParams.append(String.join(",", valueArray));
            requestParams.append("&");
        });
        if (requestParams.length() > 0) {
            requestParams.setLength(requestParams.length() - 1);
        }
        return requestParams.toString();
    }

    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String methodName = joinPoint.getSignature().getDeclaringTypeName()
                + "." + methodSignature.getMethod().getName();
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        // 打印出参
        log.info("ResponseBody(BeforeUnionReturn):methodName={},result={}", methodName, JSON.toJSONString(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}
