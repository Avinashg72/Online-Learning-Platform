package com.skillelevate.controller;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

import com.skillelevate.webrtc.SignalMessage;

@Controller
public class RoomSignalingController {

    @MessageMapping("/room/{courseId}/signal")
    @SendTo("/topic/room/{courseId}")
    public SignalMessage relay(@DestinationVariable String courseId,
                               SignalMessage message) {
        message.setRoomId(courseId);
        return message;
    }
}

