package com.zty.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.zty.project.dao.UserDao;
import com.zty.project.entity.User;
import com.zty.project.service.TokenService;
import com.zty.project.service.UserService;
import com.zty.project.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "登录接口")
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {


    @Autowired
    UserDao userDao;


    @Autowired
    TokenService tokenService;

    @ApiOperation(value = "登录接口", notes = "测试数据:{\"username\":\"admin\",\"password\":\"123456\"}")
    @PostMapping("/login")
    public Msg login(@RequestBody Map map) {
        System.out.println(map);
        Msg msg=new Msg();
        User user = userDao.findByUsername(map);
        if (user == null) {
            msg.setMessage("登录失败,用户不存在");
            return msg;
        } else {
            if(user.getPassword().equals(map.get("password"))){
                msg.setMessage("登录成功!");
                return msg;
            }else {
                msg.setMessage("密码错误,登录失败!");
                return msg;
            }
        }
    }

}
