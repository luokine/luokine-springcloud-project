package com.luokine.basic.service.intercepter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tiantziquan
 * @create: 2019-10-08 14:48
 */

@Aspect
@Component
@Order(1)
public class WebLogAspect
{
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.luokine.basic.service.controller..*.*(..))")
    public void webLog() {};

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable
    {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        printReuestMsg(request, joinPoint);

    }

    private void printReuestMsg(HttpServletRequest request, JoinPoint joinPoint)
    {
        logger.info("【full requestURL】:" + request.getRequestURL().toString());
        logger.info("【remoteAddr】:" + request.getRemoteAddr());
        logger.info("【remoteHost】:" + request.getRemoteHost());
        logger.info("【localAddr】:" + request.getLocalAddr());
        logger.info("【method】:" + request.getMethod());
        logger.info("【headers】:" + getHeadersInfo(request));
        logger.info("【parameters】:" + this.getParam(request.getParameterMap()));
        logger.info("【classMethod】:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    private String getParam(Map<String, String[]> map)
    {
        StringBuilder str = new StringBuilder();
        for(String key : map.keySet())
        {
            if(!str.toString().equals(""))
                str.append("&");
            str.append(key + "= " + String.join(",", map.get(key)));
        }
        return str.toString();
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request)
    {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements())
        {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(Object response) throws Throwable
    {
        // 处理完请求，返回内容
        logger.info("【RESPONSE】: " + response);
        logger.info("【SPEND TIME】: " + (System.currentTimeMillis() - startTime.get()));
    }
}
