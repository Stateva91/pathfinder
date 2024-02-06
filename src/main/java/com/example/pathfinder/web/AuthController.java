package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm(){
      return new UserRegistrationDTO();
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
      return "register";
    }
    @PostMapping ("/register")
    public String doRegister(@Valid UserRegistrationDTO userRegistrationDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        System.out.println(userRegistrationDTO.toString());
        if(bindingResult.hasErrors()){
            //pass dto to template
            //pass errors to template
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            return "redirect:/register";

        }
        //check if passwords match
        //check if username/email is used

        //insert in db
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
