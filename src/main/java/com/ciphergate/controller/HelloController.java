package com.ciphergate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cipher-gate")
public class HelloController {

  // Adding a route
  @GetMapping("/hello")
  public String greet() {
    return "Hello World";
  }
}
