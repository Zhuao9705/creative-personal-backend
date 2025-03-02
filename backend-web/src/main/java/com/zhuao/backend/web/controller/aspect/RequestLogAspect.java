package com.zhuao.backend.web.controller.aspect;


import com.alibaba.fastjson.JSON;
import com.zhuao.backend.web.controller.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 请求日志信息记录
 * author: zhn4528
 * create: 2021/1/17 0:44
 */
@Slf4j
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 3)
public class RequestLogAspect {

    @Resource
    private WebUtil webUtil;
    // 忽略的方法集合
    private static final Set<String> IGNORE_METHOD_SET = new HashSet<>();

    @Pointcut(value = "execution(* com.zhuao.backend.web.controller..*.*(..)) "
            // 移除探活接口
            + "&& !execution(* com.zhuao.backend.web.controller.health.HealthController.*(..))"
    )
    public void logAspect() {
    }

    @Before("logAspect()")
    public void before(JoinPoint jp) {
        String bodyStr;
        try {
            bodyStr = JSON.toJSONString(Arrays.toString(jp.getArgs()));
        } catch (Exception e) {
            log.info("logAspect::e={}", e.getMessage());
            bodyStr = "";
        }
        log.info(
                "\n\nRequestIP: {}\nMethod: {}\nURL: {}\nHeaders: {}\nRequestParam: {}\nRequestBody: {}",
                webUtil.getClientIp(), webUtil.getMethod(), webUtil.getURL(),
                JSON.toJSONString(webUtil.getAllHeaders()),
                webUtil.getRequestParams(), bodyStr
        );
    }

    @AfterReturning(pointcut = "logAspect()", returning = "result")
    public Object AfterExec(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String methodName = joinPoint.getSignature().getDeclaringTypeName()
                + "." + methodSignature.getMethod().getName();

        if (!IGNORE_METHOD_SET.contains(methodName)) {
            log.info("\nResponseBody(BeforeUnionReturn):methodName={},result={}", methodName, JSON.toJSONString(result));
        }
        return result;
    }
}
