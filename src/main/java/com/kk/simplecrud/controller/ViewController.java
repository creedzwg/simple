package com.kk.simplecrud.controller;

import com.kk.simplecrud.entity.User;
import com.kk.simplecrud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zwg15
 * @Date: 2019/6/6
 * @Version: V1.0
 * @Description: 视图显示
 */
@Controller
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userService.list());
        return "list";
    }
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.create(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.update(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.deleteById(id);
        return "redirect:/list";
    }

}
