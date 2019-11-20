package com.zty.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.zty.project.dao.UserDao;
import com.zty.project.entity.User;
import com.zty.project.service.TokenService;
import com.zty.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object login(User user) {
        System.out.println(user.getUsername() + ":" + user.getPassword());
        JSONObject jsonObject = new JSONObject();
        User userForBase = userDao.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                String message = "登录成功";
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                jsonObject.put("message", message);
                return jsonObject;
            }
        }
    }

}
