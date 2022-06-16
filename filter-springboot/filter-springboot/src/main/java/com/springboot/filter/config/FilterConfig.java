package com.springboot.filter.config;

import com.springboot.filter.util.UrlPatternFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean<UrlPatternFilter> filterFilterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new UrlPatternFilter());
        filterRegistrationBean.addUrlPatterns("/home-pattern");
        return filterRegistrationBean;
    }
}
