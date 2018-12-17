package cn.itcast.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/findLoninUser")
    public void findLoninUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);

    }
}
