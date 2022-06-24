package com.busraciftlik.controller;

import com.busraciftlik.dto.LoginDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller()
@Log4j2
public class LoginController {

    //localhost:8080/validation
    @GetMapping("validation")
    public String getLogin(Model model){

        model.addAttribute("validation_key",new LoginDto());
        return "loginCustom";
    }

    //http://localhost:8080/validation
    @PostMapping("validation")
    public String postLogin(@Valid @ModelAttribute("validation_key") LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error(" Giriş sırasında hata oluştu.");
            return "loginCustom";
        }
        log.info(loginDto);
        //Database
        loginDto=null;
        return "loginCustom";
    }


}