package com.yahqoob.CalculServeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
@Controller
public class MonControlleur {

    @Autowired
    public fibService Fib;

    @GetMapping("/fibo/{nb}")
    public @ResponseBody String trucs(@PathVariable int nb)  {
        return Fib.fibonacci(nb).toString();
    }
}
