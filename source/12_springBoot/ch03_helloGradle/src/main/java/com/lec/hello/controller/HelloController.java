package com.lec.hello.controller;

import com.lec.hello.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HelloController {

  @GetMapping("/")
  public String index(Model model) {
    log.info("home Load");
    model.addAttribute("greeting", "Hello, Spring Boot");
    return "home";
  }

  @GetMapping("confirm")
  @ResponseBody
  public String confirm(@RequestParam(value="name", required = false, defaultValue = "아무개") String name) {
    return name + "님 감사합니다. 맛점하세요.";
  }

  @GetMapping("json")
  @ResponseBody
  public Person json(@RequestParam(value="name", required = false, defaultValue = "아무개") String name,
                     @RequestParam(value = "age", required = false, defaultValue = "5") int age) {
    Person person = new Person(name, age);
    return person;
  }
}
