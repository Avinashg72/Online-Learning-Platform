package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.Lesson;
import com.learn.repositories.LessonRepository;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    
    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.addLesson(lesson);
    }
    
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }
    
    public List<Lesson> getAllLessons() {
        return lessonRepository.getAllLessons();
    }
    
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.updateLesson(lesson);
    }
    
    public void deleteLesson(Long id) {
        lessonRepository.deleteLesson(id);
    }
}
