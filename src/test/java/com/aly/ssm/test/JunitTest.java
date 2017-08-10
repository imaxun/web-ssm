package com.aly.ssm.test;

import com.aly.ssm.model.User;
import com.aly.ssm.model.UserDTO;
import com.aly.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void aa() {
       List<UserDTO> users  =  userService.find(null);
        System.out.println(users.size());
    }
}
