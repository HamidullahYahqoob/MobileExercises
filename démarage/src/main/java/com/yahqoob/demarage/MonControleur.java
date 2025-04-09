package com.yahqoob.demarage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonControleur {

    @GetMapping
    public @ResponseBody String bonjour() {
        return "bonjour le monde";
    }

}
