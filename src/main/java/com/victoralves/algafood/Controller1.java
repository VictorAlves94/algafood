package com.victoralves.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Controller1 {

    @GetMapping("/hello")
        @ResponseBody
    public String hello() {
        return "olá";
    }
}
