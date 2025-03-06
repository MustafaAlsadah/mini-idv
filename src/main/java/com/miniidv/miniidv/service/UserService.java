package com.miniidv.miniidv.service;

import com.miniidv.miniidv.repository.UserRepository;
import com.miniidv.miniidv.enums.UserStatus;
import com.miniidv.miniidv.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User addUser(User user) {
        user.setStatus(UserStatus.REGISTERED);
        user.setDocuments(new ArrayList<>()); //set empty array
        return userRepo.save(user);
    }

    public User getUserById(int id){
        return userRepo.getReferenceById(id);
    }
}
