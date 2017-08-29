package com.aly.ssm.test;

import com.aly.ssm.model.User;
import com.aly.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lizhen
 * @Date 2017/8/10 11:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/*.xml")
public class JunitTest {
    @Autowired
    private UserService userService;

    @Test
    public void aa() throws  Exception{
        User user = new User();
        user.setName("我的测试数据5");
        User user2 = new User();
        user2.setName("我的测试数据6");
        List<User> lsit = new ArrayList<User>();
        lsit.add(user);
        lsit.add(user2);
        userService.createCore(lsit);
    }
}
