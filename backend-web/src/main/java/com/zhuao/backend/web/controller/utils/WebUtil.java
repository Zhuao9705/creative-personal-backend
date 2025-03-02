package com.zhuao.backend.web.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * author: zhn4528
 * create: 2022/5/6 14:49
 */
@Component
public class WebUtil {

    @Autowired
    private HttpServletRequest request;

    public String getClientIp() {
        return IPUtil.getIpAddr(request);
    }

    public String getURL() {
        return request.getRequestURL().toString();
    }

    public String getRequestParams() {
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

    public String getMethod() {
        return request.getMethod();
    }

    public Map<String, String> getAllHeaders() {
        Map<String, String> headerMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                headerMap.put(headerName, request.getHeader(headerName));
            }
        }

        return headerMap;
    }

}
