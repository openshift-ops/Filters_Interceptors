package com.springboot.interceptor.filter;

import com.springboot.interceptor.interceptor.GeneralInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GeneralFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(GeneralInterceptor.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("Filter invoked before request");

        filterChain.doFilter(request,response);

        log.info("Filter invoked after response");

    }
}
