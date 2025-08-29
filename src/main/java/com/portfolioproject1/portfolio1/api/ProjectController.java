package com.portfolioproject1.portfolio1.api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    public record Project(
            String id,
            String name,
            String description,
            List<String> tech,
            String github,
            String demo
    ) {}

    @GetMapping
    public List<Project> list() {
        return List.of(
                new Project(
                        "p1",
                        "E-commerce",
                        "Storefront built with Spring Boot + React",
                        List.of("Java","Spring Boot","React","PostgreSQL"),
                        "https://github.com/YOUR_GH/ecommerce",
                        "https://demo.example"
                ),
                new Project(
                        "p2",
                        "Employee Manager",
                        "CRUD app with REST APIs",
                        List.of("Java","Spring Boot","MySQL"),
                        "https://github.com/YOUR_GH/employee-manager",
                        null
                )
        );
    }
}
