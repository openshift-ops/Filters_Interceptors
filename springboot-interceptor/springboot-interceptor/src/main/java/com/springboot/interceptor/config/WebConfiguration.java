package com.springboot.interceptor.config;

import com.springboot.interceptor.interceptor.AuthenticationInterceptor;
import com.springboot.interceptor.interceptor.GeneralInterceptor;
import com.springboot.interceptor.interceptor.SpecificUrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private GeneralInterceptor  generalInterceptor;

    @Autowired
    private SpecificUrlInterceptor specificUrlInterceptor;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor);
        registry.addInterceptor(generalInterceptor).order(1); //here we can add interceptors
        registry.addInterceptor(specificUrlInterceptor).order(2).addPathPatterns("/user/**"); //multiple interceptors will be called according to the defined order
    }
}
