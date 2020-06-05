package com.kafei.usercoffee.config;

import com.kafei.usercoffee.dao.UserDao;
import com.kafei.usercoffee.model.Permission;
import com.kafei.usercoffee.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: //开启基于WebSecurity的注解(已经开启了@Configuration)
 * @date 2020/5/29 17:16
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    @Qualifier(value = "myUserDetailsService")
    private UserDetailsService userDetailsService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    /**
     * @return ${return_type}
     * @throws
     * @Description: 配置认证用户信息和权限
     * @author kafei
     * @date 2020/5/30 11:40
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1.配置动态账号登录与数据库关联
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            //对表单密码进行加密
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            //加密的密码与数据库中的密码进行比对
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                //System.out.println("rawPassword:" + rawPassword + ",encodedPassword:" + encodedPassword);
                return MD5Util.encode((String) rawPassword).equals(encodedPassword);
            }
        });
    }

    /**
     * @return ${return_type}
     * @throws
     * @Description: 配置拦截请求资源
     * @author kafei
     * @date 2020/5/30 11:41
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        //1.读取所有权限
        List<Permission> permissionList = userDao.queryAllPermission();
        for (Permission permission : permissionList) {
            authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
        }
        http.headers().frameOptions().disable();
        authorizeRequests.and().csrf().disable().formLogin().loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .and()
                .logout()//退出登录
                .logoutUrl("/logout")
                .deleteCookies()//消除cookies
                .logoutSuccessUrl("/login")//退出成功后的页面请求
                .invalidateHttpSession(true)//销毁session
                .permitAll().and().authorizeRequests()
                .antMatchers("/login","/register","/").permitAll()
                //所有的请求都需要登录验证之后才可以访问
                .anyRequest().authenticated() //其他路径都要拦截
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**","/LoginController/userRegister");
    }

    /*@Bean
    public static NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }*/
}
