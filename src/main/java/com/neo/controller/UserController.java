package com.neo.controller;

import com.neo.model.User;
import com.neo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;


    /**
     * 操作完成以后重定向到用户列表页
     *
     * @return
     */
    @RequestMapping("/user")
    public String index() {
        //重定向到／list接口
        return "redirect:/userlist";
    }

    @RequestMapping("/editUser")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/userlist";
    }

    @RequestMapping("/addUser")
    public String add(User user) {
        userService.save(user);
        return "redirect:/userlist";
    }

    @RequestMapping("/deleteUser")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/userlist";
    }

    @RequestMapping("/userlist")
    public String list(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "view_user/list";
    }

    /**
     * view显示
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toEditUser")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "view_user/userEdit";
    }

    @RequestMapping("/toAddUser")
    public String toAdd() {
        return "view_user/userAdd";
    }

}
