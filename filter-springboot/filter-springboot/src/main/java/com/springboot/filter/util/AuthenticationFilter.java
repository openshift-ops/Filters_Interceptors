package com.springboot.filter.util;

import com.springboot.filter.exception.BadCredentialsException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Filter;

@Component
@ConditionalOnProperty
public class AuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final String authHeader = request.getHeader("Authorization");
        log.info("Get the authorization header " + request.getHeader("Authorization"));

        String token = null;
        String username = null;
        String password = null;
        boolean authenticated = false;
        if(authHeader != null && authHeader.startsWith("Basic "))
        {
            token = authHeader.substring(6);
        }
        if(token != null)
        {
            final String actualToken = new String(Base64.decodeBase64(token));
            StringTokenizer stringTokenizer = new StringTokenizer(actualToken,":");
            if(stringTokenizer.countTokens() > 0)
            {
                username = stringTokenizer.nextToken();
                password = stringTokenizer.nextToken();
            }

            if("foo".equals(username) && "foo".equals(password))
            {
                authenticated = true;
            }

        }
        if(authenticated)
        {
            filterChain.doFilter(request,response);
        }
        else {
            response.sendError(401,"Incorrect credentials");
        }
    }
}
