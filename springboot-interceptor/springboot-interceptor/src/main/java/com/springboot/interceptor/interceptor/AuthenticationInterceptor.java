package com.springboot.interceptor.interceptor;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.StringTokenizer;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

    private static final Logger log = LoggerFactory.getLogger(GeneralInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //called before the request goes to the handler or controller
        log.info("in the pre handle of AuthenticationInterceptor");
        {


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

                return "foo".equals(username) && "foo".equals(password);

            }
        }
        response.sendError(401,"Incorrect user name and password");
        //response.sendRedirect("/badcred");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //called after  the response comes from the  handler or controller
        log.info("in the post handle of AuthenticationInterceptor");
        //log.info("response is " + response.getWriter());

    }

    @Override

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //if the app renders any view/jsp then this method is called after the model has been injected into the view and it has been rendered
        log.info("in the afterCompletion of AuthenticationInterceptor");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
