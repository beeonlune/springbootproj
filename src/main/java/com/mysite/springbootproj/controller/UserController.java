package com.mysite.springbootproj.controller;

import com.mysite.springbootproj.model.User;
import com.mysite.springbootproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // аннотация @Controller указывает, что этот класс является контроллером в архитектуре MVC (Model-View-Controller) и обрабатывает веб-запросы.
public class UserController {

    private final UserService userService;

    @Autowired // объявляется поле userService, представляющее сервис для работы с пользователями, и используется аннотация @Autowired для внедрения зависимости UserService в контроллер
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "UserList";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/users";
    }


    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user-search")
    public String searchUserByLastName(@RequestParam("lastName") String lastName, Model model){
        List<User> users = userService.findByLastName(lastName);
        model.addAttribute("users", users);
        return "UserList";
    }
}
