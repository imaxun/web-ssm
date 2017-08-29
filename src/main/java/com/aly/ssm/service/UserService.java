package com.aly.ssm.service;

import com.aly.ssm.model.User;
import com.aly.ssm.model.UserDTO;

import java.util.List;

/**
 * Created by lizhen on 2017/7/6.
 */
public interface UserService {
    List<UserDTO> find(User user);

    int save(User user);


    /**
     * 批量新增
     *
     * @param list
     * @throws Exception
     */

    void createCore(List<User> list) throws Exception;

    User findById(Integer id);
}
