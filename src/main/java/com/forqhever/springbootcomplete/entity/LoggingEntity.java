package com.forqhever.springbootcomplete.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LoggingEntity implements Serializable {

    private static final long serialVersionUID = -6442823887202844854L;

    private LocalDateTime requestDateTime;
    private String requestUri;
    private String requestParam;
    private String requestHttpMethod;
    private String handlerMethodName;
    private float handlerCostSeconds;
    private String handlerException;
    private Object responseResult;

    private LoggingEntity(LocalDateTime requestDateTime, String requestUri, String requestParam,
                         String requestHttpMethod, String handlerMethodName, float handlerCostSeconds,
                         String handlerException, Object responseResult) {
        this.requestDateTime = requestDateTime;
        this.requestUri = requestUri;
        this.requestParam = requestParam;
        this.requestHttpMethod = requestHttpMethod;
        this.handlerMethodName = handlerMethodName;
        this.handlerCostSeconds = handlerCostSeconds;
        this.handlerException = handlerException;
        this.responseResult = responseResult;
    }

    public LocalDateTime getRequestDateTime() {
        return requestDateTime;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public String getRequestHttpMethod() {
        return requestHttpMethod;
    }

    public String getHandlerMethodName() {
        return handlerMethodName;
    }

    public float getHandlerCostSeconds() {
        return handlerCostSeconds;
    }

    public String getHandlerException() {
        return handlerException;
    }

    public Object getResponseResult() {
        return responseResult;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    static class Builder {
        private LocalDateTime requestDateTime;
        private String requestUri;
        private String requestParam;
        private String requestHttpMethod;
        private String handlerMethodName;
        private float handlerCostSeconds;
        private String handlerException;
        private Object responseResult;

        Builder requestDateTime(LocalDateTime requestDateTime) {
            this.requestDateTime = requestDateTime;
            return this;
        }

        Builder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }

        Builder requestParam(String requestParam) {
            this.requestParam = requestParam;
            return this;
        }

        Builder requestHttpMethod(String requestHttpMethod) {
            this.requestHttpMethod = requestHttpMethod;
            return this;
        }

        Builder handlerMethodName(String handlerMethodName) {
            this.handlerMethodName = handlerMethodName;
            return this;
        }

        Builder handlerException(String handlerException) {
            this.handlerException = handlerException;
            return this;
        }

        Builder handlerCostSeconds(float handlerCostSeconds) {
            this.handlerCostSeconds = handlerCostSeconds;
            return this;
        }

        Builder responseResult(Object responseResult) {
            this.responseResult = responseResult;
            return this;
        }

        LoggingEntity build() {
            LoggingEntity loggingEntity = new LoggingEntity(requestDateTime, requestUri, requestParam, requestHttpMethod,
                    handlerMethodName, handlerCostSeconds, handlerException, responseResult);
            return loggingEntity;
        }
    }

}
