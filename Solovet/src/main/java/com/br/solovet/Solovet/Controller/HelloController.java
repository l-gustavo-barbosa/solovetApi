package com.br.solovet.Solovet.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    public void hello(){
        System.out.println("Hello World!");
    }
}
