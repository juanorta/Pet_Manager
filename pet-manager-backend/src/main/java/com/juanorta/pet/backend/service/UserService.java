package com.juanorta.pet.backend.service;

import com.juanorta.pet.backend.entity.User;
import com.juanorta.pet.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
       
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) { return repository.saveAll(users);}

    public List<User> getUsers(){ return repository.findAll();}

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) { return repository.findByEmail(email);}

    public String deleteUser(int id){
        repository.deleteById(id);
        return "user removed! " + id;
    }

    public User updateUser(User user){
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setEmail(user.getEmail());
        existingUser.setSocial_type(user.getSocial_type());
        return repository.save(existingUser);
    }
}
