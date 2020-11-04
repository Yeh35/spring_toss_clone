package me.sangoh.spring_toss_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProjectApplication.class);
        app.run(args);
    }
}