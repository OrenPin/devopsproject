package com.example.devopsproject.controller;

import com.example.devopsproject.model.Log;
import com.example.devopsproject.repos.LogRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class LogController {
    private final LogRepo logRepo;

    public LogController(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    @GetMapping("/logs")
    public List<Log> getLogs() {
        // Retrieve all logs
        return logRepo.findAll();
    }

    @GetMapping("/transaction")
    public String createTransaction() {
        // Create a new log entry for a transaction
        Log logEntry = new Log("/transaction", new Date());
        logRepo.save(logEntry);
        return "A new transaction has been created.";
    }
}
