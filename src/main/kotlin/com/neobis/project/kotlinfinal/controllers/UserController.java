package com.neobis.project.kotlinfinal.controllers;

import com.neobis.project.kotlinfinal.models.User;
import com.neobis.project.kotlinfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;


// Done
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String defaultUser() {
        return "Default user endpoint";
    }

    // update use
    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    // create new user
    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // delete user
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUserById(@PathParam("id") int id) {
        userService.deleteUserById(id);
    }
}