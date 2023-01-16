package com.security.springbootsecurity.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.springbootsecurity.Model.User;

@Service
public class UserServices {
    List<User> list = new ArrayList<>();
    public UserServices(){
        list.add(new User("abc", "abc", "abc@gmail.com"));
        list.add(new User("xyz", "xyz", "abc@gmail.com"));
    }

    // Get all Users 
    public List<User> getAllUsers(){
        return list;
    }

    // get user by user name
    public User getUserByName(String username){

        return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    // Add a nbew user to the user list 
     public User addAUser(User user){

        this.list.add(user);
        return user;
    }


}
