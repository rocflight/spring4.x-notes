package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by zhangpengxiang on 2019/9/15.
 */
@ContextConfiguration("classpath*:/smart-context.xml") //启动spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","1231");
        assertTrue(b1);
        assertFalse(b2);
    }

    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        String password = user.getPassword();
        assertEquals(password,"123456");
    }
}
