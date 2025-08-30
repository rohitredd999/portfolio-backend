package com.portfolioproject1.portfolio1.api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    public record Project(
            String id, String name, String description,
            List<String> tech, String github, String demo) {}

    @GetMapping
    public List<Project> list() {
        return List.of(
                new Project("p1","E-commerce","Spring Boot + React demo",
                        List.of("Java","Spring Boot","React"), "https://github.com/YOUR_GH/ecommerce", null),
                new Project("p2","Employee Manager","CRUD REST demo",
                        List.of("Java","Spring Boot","MySQL"), "https://github.com/YOUR_GH/employee-manager", null)
        );
    }
}

@RestController
class HealthController {
    @GetMapping("/healthz") public String health() { return "ok"; }
}

