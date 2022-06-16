package com.springboot.interceptor.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SpecificUrlInterceptor implements HandlerInterceptor{

    private static final Logger log = LoggerFactory.getLogger(GeneralInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //called before the request goes to the handler or controller
        log.info("in the pre handle of SpecificUrlInterceptor");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //called after  the response comes from the  handler or controller
        log.info("in the post handle of SpecificUrlInterceptor");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //if the app renders any view/jsp then this method is called after the model has been injected into the view and it has been rendered
        log.info("in the afterCompletion of SpecificUrlInterceptor");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
