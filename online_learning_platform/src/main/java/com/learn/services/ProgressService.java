package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.Progress;
import com.learn.repositories.ProgressRepository;

@Service
public class ProgressService {
    @Autowired
    private ProgressRepository progressRepository;
    
    public Progress updateProgress(Progress progress) {
        return progressRepository.updateProgress(progress);
    }
    
    public Progress getProgressById(Long id) {
        return progressRepository.getProgressById(id);
    }
    
    public List<Progress> getAllProgress() {
        return progressRepository.getAllProgress();
    }
    
    public Object deleteProgress(Long id) {
        return progressRepository.deleteProgress(id);
    }

	public List<Progress> getProgressByUser(Long userId) {
		
		return progressRepository.getProgressByUser(userId);
	}
}
