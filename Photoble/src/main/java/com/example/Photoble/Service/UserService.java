package com.example.Photoble.Service;

import com.example.Photoble.Entity.User;
import com.example.Photoble.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


}
