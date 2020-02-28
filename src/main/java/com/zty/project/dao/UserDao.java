package com.zty.project.dao;


import com.zty.project.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao {
    //根据username查询登录账号信息
    User findByUsername(Map map);

    //根据id查询登录账号信息
    User findUserById(User user);
}
