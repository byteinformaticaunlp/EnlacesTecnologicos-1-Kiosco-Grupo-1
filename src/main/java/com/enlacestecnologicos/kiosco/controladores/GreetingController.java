package com.enlacestecnologicos.kiosco.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

  @GetMapping("/greeting")
  public String greeting() {
    return "index"; // Thymeleaf busca automáticamente templates/index.html
  }
}