package org.krd.khmer.controller;

import org.krd.khmer.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {

    @RequestMapping({"/", "/dashboard"})
    public String homePage() {
        return "dashboard";
    }

    @RequestMapping("/user")
    public String userPage() {
        return "user";
    }
    @RequestMapping("/userlist")
    public String userListPage() {
        return "userlist";
    }

    @RequestMapping("/role")
    public String rolePage() {
        return "role";
    }
    @RequestMapping("/rolelist")
    public String roleListPage() {
        return "rolelist";
    }

    







    @RequestMapping("/user-cu")
    public String userCUPage(ModelMap model) {
        model.addAttribute("USER", new User());
        return "user-cu";
    }

    @RequestMapping("/user-c")
    @ResponseBody
    public User userC(@ModelAttribute User user) {
        return user;
    }



}
