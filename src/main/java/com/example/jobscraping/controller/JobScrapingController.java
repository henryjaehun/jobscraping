package com.example.jobscraping.controller;

import com.example.jobscraping.service.JobScrapingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/scrape")
public class JobScrapingController {
    private final JobScrapingService jobScrapingService;

    public JobScrapingController(JobScrapingService jobScrapingService) {
        this.jobScrapingService = jobScrapingService;
    }

    @GetMapping
    public String scrapeJobs() {
        try {
            jobScrapingService.scrapJobTitles();
            return "jobs scraped successfully";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
