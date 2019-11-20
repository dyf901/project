package com.zty.project.dao;


import com.zty.project.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //根据username查询登录账号信息
    User findByUsername(User user);

    //根据id查询登录账号信息
    User findUserById(User user);
}
