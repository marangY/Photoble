package com.example.Photoble.controller;

import com.example.Photoble.entity.User;
import com.example.Photoble.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String getLogin(){

        return "user/login";
    }

    @PostMapping("/login")
    public String postLogin(User user, HttpSession session){

        if(userService.loginProcess(user)){
            return "redirect:/login";
        }

        session.removeAttribute("userName");
        session.setAttribute("userName", user.getUserid());

        return "redirect:/cloud/main";
    }

    @GetMapping("/join")
    public String getJoin(){

        return "user/join";
    }

    @PostMapping("/join")
    public String postJoin(User user){

        if(userService.joinProcess(user)){
            return "redirect:/join";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/login";
    }

    @GetMapping("/mypage/info")
    public String mypageInfo(Model model, HttpSession session){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        return "user/mypage_info";
    }

    @GetMapping("/mypage/notice")
    public String mypagenotice(Model model, HttpSession session){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        return "user/mypage_notice";
    }
}
