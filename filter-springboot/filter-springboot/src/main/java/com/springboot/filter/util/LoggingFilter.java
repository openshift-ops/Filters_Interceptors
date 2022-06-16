package com.springboot.filter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //here we have to write the action that we want to perform before/after being processed by the DispatcherServlet
        log.info("Printing before request is served");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        log.info("Request URI " + httpRequest.getRequestURI());

        chain.doFilter(request,response);

       //so if anything needs to be done after the response is formed we have to do it here as the control from Applicationilter will come here after the response is formed
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        log.info("Response Status " + httpResponse.getStatus());
    }
}
