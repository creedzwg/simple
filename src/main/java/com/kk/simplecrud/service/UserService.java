package com.kk.simplecrud.service;

import com.kk.simplecrud.entity.User;

import java.util.List;

/**
 * @Author: zhangwengang
 * @Date: 2019/6/5
 * @Version: V1.0
 * @Description:
 */
public interface UserService {

    /**
     * 获取用户详情
     * @param id userid
     * @return User
     */
    User findUserById(Long id);

    /**
     *  创建用户
     * @param  user 用户实体
     * @return User
     */
    User create(User user);

    /**
     * 获取用户列表
     * @param pageIndex  pageIndex
     * @param pageSize pageSize
     * @return  List<User>
     */
    List<User> list(int pageIndex, int pageSize);

    /**
     * 获取用户列表
     * @return
     */
    List<User> list();


    /**
     * 删除用户
     * @param id userid
     * @return successflag
     */
    Boolean deleteById(Long id);

    /**
     *  修改用户
     * @param user
     * @return
     */
    Boolean update(User user);
}
