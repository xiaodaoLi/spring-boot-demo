package com.hgb.spring.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgb.spring.transaction.dto.User;
import com.hgb.spring.transaction.service.UserService;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public void addUser(User user) throws Exception {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser_mandatory")
    public void addUser_mandatory(User user) throws Exception {
        userService.addUser_mandatory(user);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/modifyUser")
    public User modifyUser(User user) {
        return userService.modifyUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/removeUser/{id}")
    public int removeUser(@PathVariable("id") Long id) {
        return userService.removeUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findUserById/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
}
