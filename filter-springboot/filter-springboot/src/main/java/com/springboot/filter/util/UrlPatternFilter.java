package com.springboot.filter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//Dont annotate with @Component as it needs to be executed on a specific request
public class UrlPatternFilter  implements Filter {

    private static final Logger log = LoggerFactory.getLogger(UrlPatternFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        log.info("Call me when specific api getting called");
        chain.doFilter(request,response);

    }
}
