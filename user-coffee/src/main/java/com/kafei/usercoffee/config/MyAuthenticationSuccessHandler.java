package com.kafei.usercoffee.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 认证成功
 * @date 2020/5/30 13:32
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username = httpServletRequest.getParameter("username");
        String url = "";
        if("admin".equals(username)){
            url = "/indexMent";
        } else {
            url = "/toHome";
        }
        httpServletResponse.sendRedirect(url);
    }
}
