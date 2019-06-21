package com.kk.simplecrud.controller;



import com.kk.simplecrud.entity.User;
import com.kk.simplecrud.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @Author: zhangwengang
 * @Date: 2019/6/5
 * @Version: V1.0
 * @Description:
 */

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("创建用户")
    @PostMapping("/user")
    @ApiImplicitParam(name = "user",value = "用户详细实体对象",required = true,dataType = "user")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @ApiOperation("修改用户")
    @PutMapping("/user")
    @ApiImplicitParam(name = "user",value = "用户详细实体对象",required = true,dataType = "user")
    public Boolean update(@RequestBody User user) {
        return userService.update(user);
    }


    @ApiOperation("用户详情")
    @GetMapping("/user/{id}")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",example = "1")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @ApiOperation("用户列表")
    @GetMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码数",  required = true,dataType = "Integer",example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数",  required = true,dataType = "Integer",example = "20")
    })
    public List<User> list( @RequestParam(defaultValue = "1") Integer pageIndex,
                            @RequestParam(defaultValue = "20") Integer pageSize) {

        return userService.list(pageIndex,pageSize);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/users/{id}")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long",example = "1")
    public Boolean deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }


}
