package com.itcast.web.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itcast.bean.system.User;
import com.itcast.service.system.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class UserController {

    //自动装配UserService对象
    @Reference
    private UserService userService;

    @RequestMapping(value = "/findAll", name = "查询所有")
    public List<User> list() {
        //1.1 调用业务层
        List<User> userList = userService.findAll();

        //2. 返回查询数据
        return userList;
    }

    @RequestMapping(value = "/findById", name = "条件查询")
    public User findById(String id) {
        System.out.println("xxxx=" + userService);
        //1.1 调用业务层
        User user = userService.findById(id);

        //2. 返回查询数据
        return user;
    }

    @RequestMapping(value = "/delete", name = "删除数据")
    public String delete(String id) {
        //1. 调用业务层
        userService.delete(id);

        //2. 返回操作结果
        return "删除成功";
    }
}
