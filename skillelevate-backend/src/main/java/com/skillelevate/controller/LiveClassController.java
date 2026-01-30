package com.skillelevate.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructor")
public class LiveClassController {

    @PostMapping("/create-room")
    public Map<String, String> createRoom() {
        String roomId = UUID.randomUUID().toString();
        return Map.of("roomId", roomId);
    }
}

