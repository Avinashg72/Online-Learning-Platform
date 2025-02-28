package com.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.Lesson;
import com.learn.services.LessonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    
    @PostMapping("/add")
    public Lesson addLesson(@RequestBody Lesson lesson) {
        return lessonService.addLesson(lesson);
    }
    
    @GetMapping("/{id}")
    public Lesson getLesson(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }
    
    @GetMapping("/all")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }
    
    @PutMapping("/update")
    public Lesson updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}
