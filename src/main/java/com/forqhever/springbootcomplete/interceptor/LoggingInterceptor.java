package com.forqhever.springbootcomplete.interceptor;

import com.forqhever.springbootcomplete.constant.InterceptorConstant;
import com.forqhever.springbootcomplete.entity.LoggingEntity;
import com.forqhever.springbootcomplete.entity.LoggingEntityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(InterceptorConstant.REQUEST_START_TIME_MILLIS, System.currentTimeMillis());
        request.setAttribute(InterceptorConstant.REQUEST_START_DATE_TIME, LocalDateTime.now());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoggingEntityFactory loggingEntityFactory = new LoggingEntityFactory(request, response, handlerMethod);
        LoggingEntity loggingEntity = loggingEntityFactory.getLoggingEntity();
        logger.info("REQUEST: {}", loggingEntity);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
