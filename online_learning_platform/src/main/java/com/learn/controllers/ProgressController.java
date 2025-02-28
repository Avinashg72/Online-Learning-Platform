package com.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.Progress;
import com.learn.services.ProgressService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;
    
    @PostMapping("/update")
    public Progress updateProgress(@RequestBody Progress progress) {
    	return progressService.updateProgress(progress);
    }
    
    @GetMapping("/{id}")
    public Progress getProgress(@PathVariable Long id) {
        return progressService.getProgressById(id);
    }
    
    @GetMapping("/all")
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }
    
    @DeleteMapping("/delete/{id}")
    public Object deleteProgress(@PathVariable Long id) {
        return progressService.deleteProgress(id);
    }
    
    @GetMapping("/user/{userId}")
    public List<Progress> getUserProgress(@PathVariable Long userId) {
        return progressService.getProgressByUser(userId);
    }
}