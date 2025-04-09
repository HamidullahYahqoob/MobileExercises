package com.yahqoob.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonControlleur {


    @Autowired
    public Service service;

    @GetMapping("/prout/envoyer")
    public @ResponseBody String chaine(
            @RequestParam(value = "taille",required = false,defaultValue = "10") int taille) throws IndexOutOfBoundsException {

        return service.chaine(taille);
    }
}
