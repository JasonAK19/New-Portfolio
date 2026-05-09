package com.portfolio.backend;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*")
public class PortfolioController {

    @GetMapping
    public PortfolioResponse getPortfolio() {
        return new PortfolioResponse(
            "Jason",
            "Full-Stack Developer",
            "I build polished web apps with React, Spring Boot, and Docker.",
            List.of("React", "Spring Boot", "Docker"),
            List.of(
                new Project("Portfolio Website", "Personal site with full-stack deployment"),
                new Project("API Integration", "Backend services for dynamic content")
            )
        );
    }

    public record PortfolioResponse(
        String name,
        String title,
        String bio,
        List<String> skills,
        List<Project> projects
    ) {
    }

    public record Project(String name, String description) {
    }
}
