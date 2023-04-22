package com.example.jenkinsdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDockerApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello app";
    }

    //test linux

}
