package com.example.Photoble.controller;

import com.example.Photoble.entity.Image;
import com.example.Photoble.service.CloudService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class CloudController {

    @Autowired
    CloudService cloudService;

    @GetMapping("/")
    public String home(){

        return "redirect:/cloud/main";
    }

    @GetMapping("/cloud/main")
    public String cloudMain(Model model, HttpSession session, String searchKeyword){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        List<Image> userImage = null;

        try {
            if(searchKeyword.isBlank()) {
                searchKeyword = null;
            }
        }
        catch (Exception e){

        }

        if (searchKeyword == null){
            userImage =  cloudService.returnUserImage(session);
        }
        else {
            userImage = cloudService.returnUserImageKeyword(session, searchKeyword);
        }



        model.addAttribute("userImage", userImage);
        model.addAttribute("searchKeyword", searchKeyword);

        return "cloud/cloud_main";
    }

    @GetMapping("/cloud/upload")
    public String getCloudUpload(HttpSession session){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        return "cloud/cloud_upload";
    }

    @PostMapping("/cloud/uploding")
    public String uploading(HttpSession session, String tag, Model model, MultipartFile multipartFile) throws Exception{
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        cloudService.upload(session, tag, multipartFile);

        return "redirect:/cloud/main";
    }

}
