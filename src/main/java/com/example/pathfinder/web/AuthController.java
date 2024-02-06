package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
      return "register";
    }
    @PostMapping ("/register")
    public String doRegister(@Valid UserRegistrationDTO userREgistrationDTO){
        System.out.println(userREgistrationDTO.toString());

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
