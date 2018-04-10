package com.forqhever.springbootcomplete.entity;

import com.forqhever.springbootcomplete.constant.InterceptorConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingEntityFactory {

    HttpServletRequest request;
    HttpServletResponse response;
    HandlerMethod handler;

    public LoggingEntityFactory(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) {
        this.request = request;
        this.response = response;
        this.handler = handler;
    }

    public LoggingEntity getLoggingEntity() {
        long startTimeMillis = (long) request.getAttribute(InterceptorConstant.REQUEST_START_TIME_MILLIS);
        float handlerCostSeconds = (System.currentTimeMillis() - startTimeMillis) / 1000F;
        LocalDateTime requestDateTime = (LocalDateTime) request.getAttribute(InterceptorConstant.REQUEST_START_DATE_TIME);
        String uri = request.getRequestURI();
        String httpMethod = request.getMethod();
        Method handlerMethod = handler.getMethod();
        String className = handlerMethod.getDeclaringClass().getName();
        String methodName = StringUtils.joinWith(".", className, handlerMethod.getName());
        LoggingEntity loggingEntity = new LoggingEntity.Builder()
                .requestDateTime(requestDateTime)
                .requestUri(uri)
                .requestHttpMethod(httpMethod)
                .handlerMethodName(methodName)
                .handlerCostSeconds(handlerCostSeconds)
                .build();
        return loggingEntity;
    }
}
