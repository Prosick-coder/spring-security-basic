package com.security.springbootsecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springbootsecurity.Model.User;
import com.security.springbootsecurity.Services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserServices userServices;
    // get all users
    @GetMapping("/")
    public List<User> getAll(){
        return this.userServices.getAllUsers();
    }

    // get user by ausername
    @GetMapping("/{username}")
    public User getAUser(@PathVariable("username") String username){

        return this.userServices.getUserByName(username);
    } 

    // add a user 
    @PostMapping("/")
    public User addUser(@RequestBody User user){

        return this.userServices.addAUser(user);
    }
}
