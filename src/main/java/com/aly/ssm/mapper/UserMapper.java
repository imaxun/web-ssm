package com.aly.ssm.mapper;

import com.aly.ssm.model.User;
import com.aly.ssm.model.UserDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by lizhen on 2017/7/6.
 */
public interface UserMapper extends Mapper<User> {
    List<UserDTO> find(User user);

    /**
     * 批量新增
     *
     * @param list
     * @return
     * @throws Exception
     */
    void createCore(List<User> list) throws Exception;

    void dynaInsert(User user);

    User findById(Integer id);
}
