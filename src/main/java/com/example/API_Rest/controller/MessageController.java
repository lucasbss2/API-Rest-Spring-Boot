package com.example.API_Rest.controller;

import com.example.API_Rest.service.MsgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    private final MsgService msgService;

    public MessageController(MsgService msgService) {
        this.msgService = msgService;
    }

    @GetMapping("/message")
    public String msg() {
        return msgService.getMsg();
    }
}
