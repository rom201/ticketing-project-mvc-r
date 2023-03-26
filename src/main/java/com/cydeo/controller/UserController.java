package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());


        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());

        userService.save(user);
//        model.addAttribute("users", userService.findAll());

//        return "user/create";
        return "redirect:/user/create";  //now everything updated itself
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable ("username") String usermane, Model model){

        //user
        //role
        //users
        model.addAttribute("user",userService.findById(usermane));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";

    }


    @PostMapping("/update")
    public String updateUser( UserDTO user){  //Spring understand no need Model and ModelAttribute

        userService.update(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable ("username") String usermane){

        userService.deleteById(usermane);

        return "redirect:/user/create";

    }






}
