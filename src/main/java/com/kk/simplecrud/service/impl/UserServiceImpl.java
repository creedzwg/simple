package com.kk.simplecrud.service.impl;


import com.kk.simplecrud.dao.UserRepository;
import com.kk.simplecrud.entity.QUser;
import com.kk.simplecrud.entity.User;
import com.kk.simplecrud.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangwengang
 * @Date: 2019/6/5
 * @Version: V1.0
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JPAQueryFactory jpaQueryFactory;

    public UserServiceImpl(UserRepository userRepository, JPAQueryFactory jpaQueryFactory) {
        this.userRepository = userRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /**
     * 获取用户详情
     * @param id 用户id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .where(
                        user.id.eq(id)
                )
                .fetchOne();

    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * 获取用户列表
     *
     * @param pageIndex pageIndex
     * @param pageSize  pageSize
     * @return List<User>
     */
    @Override
    public List<User> list(int pageIndex, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageIndex-1,pageSize) ).getContent();
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * 删除用户
     *
     * @param id userid
     * @return successflag
     */
    @Override
    public Boolean deleteById(Long id) {
        try {

            userRepository.deleteById(id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage(), e);

        }
        return false;
    }

    @Override
    public Boolean update(User user) {
        try {

            userRepository.save(user);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return false;
    }


}
