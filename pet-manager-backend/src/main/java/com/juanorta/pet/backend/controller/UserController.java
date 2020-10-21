package com.juanorta.pet.backend.controller;

import com.juanorta.pet.backend.entity.User;
import com.juanorta.pet.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) { return service.saveUser(user);}

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) { return service.saveUsers(users);}

    @GetMapping("/users")
    public List<User> findAllUsers(){ return service.getUsers();}

    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable int id){ return service.getUserById(id);}

    @GetMapping("/user/{email}")
    public User findUserByEmail(@PathVariable String email){ return service.getUserByEmail(email);}

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){ return service.updateUser(user);}

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){ return service.deleteUser(id);}
}
