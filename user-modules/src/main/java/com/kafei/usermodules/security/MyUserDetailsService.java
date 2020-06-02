package com.kafei.usermodules.security;

import com.kafei.usermodules.dao.UserDao;
import com.kafei.usermodules.model.Permission;
import com.kafei.usermodules.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 设置动态用户信息
 * @date 2020/6/1 13:00
 */
@Service(value = "myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1.根据用户名获取用户信息
        User user = userDao.queryUserInformationByUserName(username);
        //2.底层会根据数据库查询的用户信息，来判断密码是否正确
        //3.给用户设置权限
        List<Permission> permissions = userDao.queryUserPermissionByUserName(username);
        if (permissions != null && permissions.size() > 0) {
            //定义用户权限
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Permission permission:permissions){
                authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
            }
            user.setAuthorities(authorities);
        }
        return user;
    }
}
