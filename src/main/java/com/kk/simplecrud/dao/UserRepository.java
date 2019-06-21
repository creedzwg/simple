package com.kk.simplecrud.dao;

import com.kk.simplecrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @Author: zhangwengang
 * @Date: 2019/6/5
 * @Version: V1.0
 * @Description:
 */

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {



}
