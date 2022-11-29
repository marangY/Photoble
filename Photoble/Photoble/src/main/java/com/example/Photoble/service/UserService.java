package com.example.Photoble.service;

import com.example.Photoble.entity.User;
import com.example.Photoble.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean loginProcess(User user){
        User findUser = userRepository.findByUseridAndPassword(user.getUserid(), user.getPassword());

        if(findUser == null){
            return true;
        }

        return false;
    }

    public Boolean joinProcess(User user){
        User selectUser = userRepository.findByUserid(user.getUserid());

        if (selectUser == null){

        }
        else if(selectUser.getUserid() != null){
            return true;
        }

        userRepository.save(user);

        return false;
    }
}
