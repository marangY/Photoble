package com.example.Photoble.Controller;

import com.example.Photoble.Entity.Board;
import com.example.Photoble.Entity.User;
import com.example.Photoble.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String Login() {

        return "User/Login";
    }

    @GetMapping("/join")
    public String Join(){

        return "User/Join";
    }

    @GetMapping("/mypage/info")
    public String mypageInfo(){

        return "User/MyPage_info";
    }

    @GetMapping("/mypage/notice")
    public String mypageNotice(){

        return "User/MyPage_notice";
    }

}
