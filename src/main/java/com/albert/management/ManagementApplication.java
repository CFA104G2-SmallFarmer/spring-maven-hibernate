package com.albert.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ManagementApplication {
  private static final Logger log = LoggerFactory.getLogger(ManagementApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ManagementApplication.class, args);
    log.debug(
      "\n----------------------------------------------------------------------\n\t" + 
      "Application '{}' is running!\n" + 
      "----------------------------------------------------------------------",
      ManagementApplication.class.getSimpleName()
    );
  }

  @GetMapping("/hello")
  public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }


}
