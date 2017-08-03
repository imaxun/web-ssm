package com.aly.ssm.controller;

import com.aly.ssm.model.ResultPageBean;
import com.aly.ssm.model.User;
import com.aly.ssm.model.UserDTO;
import com.aly.ssm.service.UserService;
import com.aly.ssm.uitl.RedisUtil;
import com.aly.ssm.uitl.Result;
import com.aly.ssm.uitl.ResultSupport;
import com.aly.ssm.uitl.ResultUtil;
import com.aly.ssm.uitl.model.commonLog;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lizhen on 2017/7/6.
 */
@Controller
@RequestMapping("/user")
public class UserController extends commonLog {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisTemplate;

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public Result find(User user) {
        Page<List<UserDTO>> page = null;
        ResultPageBean pageBean = null;
        try {
            page = PageHelper.startPage(user.getPageNum(), user.getPageSize());
            List<UserDTO> users = userService.find(user);
            if (pageBean == null) {
                pageBean = new ResultPageBean();
                pageBean.setModel(users);
                pageBean.setPageNum(page.getPageNum());
                pageBean.setPages(page.getPages());
                pageBean.setPageSize(page.getPageSize());
                pageBean.setTotal(page.getTotal());
            }
        } catch (Exception e) {
            logger.info("查询出现异常:" + e.getMessage());
            e.printStackTrace();
            return new ResultSupport("500", "查询出现异常", pageBean);
        }
        return ResultUtil.success(pageBean);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody User user) {
        return notAll(user);
    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    @ResponseBody
    public Result addList(@RequestBody List<User> users) {
        Result result = new ResultSupport();
        try {
            userService.createCore(users);
        } catch (Exception e) {
            logger.info("批量新增出现异常:" + e.getMessage());
            e.printStackTrace();
            return new ResultSupport("500", "批量新增出现异常", null);
        }
        return ResultUtil.success(null);
    }

    public boolean checkBorrowNid(Integer id) {
        String key = "admin" + id;
        boolean exist = redisTemplate.exists(key);
        if (exist) {
            return false;
        }
        if (redisTemplate.setNX(key, "1")) {
            //保存5分钟,后自动删除
            redisTemplate.set(key, "1", 300L);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除key（标的id）
     */
    public void removeKey(Integer id) {
        redisTemplate.remove("admin" + id);
    }

    public Result notAll(User user) {
        long start = System.currentTimeMillis();// 记录起始时间
        Result result = new ResultSupport();
        Integer productInfo = user.getUserId();
        int isacc = 0;
        try {
            //通过redis校验标的id唯一性
            boolean isUk = checkBorrowNid(productInfo);
            if (!isUk) {
                isacc = 1;
                result = ResultUtil.errorField("提示1：用户的Id已存在：" + productInfo);
                return result;
            }
            //校验用户的id必须唯一
            User isuser = userService.findById(productInfo);
            int aa = 0;
            int bb = 10;
            System.out.println(bb / aa);
            if (isuser != null) {
                result = ResultUtil.errorField("提示：用户的Id已存在：" + productInfo);
                return result;
            } else {
                System.out.println("----------3--------");
//                Thread.sleep(1000);
                user.setState(1);
            }
            throw new Exception("编号已经存在");
        } catch (Exception e) {
            isacc = 1;
            e.printStackTrace();
        } finally {
            int is = userService.save(user);
            if (is > 0) {
                System.out.println("新增成功：" + productInfo);
            }
            //删除redis中的key
            if (isacc == 0) {
                removeKey(productInfo);
            }
            long end = System.currentTimeMillis(); // 记录结束时间2
            System.out.println(("查询线程-消耗毫秒：" + (end - start)));
        }
        return result;
    }

//    public synchronized boolean isNull(Integer userId) {
//        boolean isok = true;
//        if (userService.findById(userId) != null) {
//            return false;
//        }
//        return isok;
//    }
}
