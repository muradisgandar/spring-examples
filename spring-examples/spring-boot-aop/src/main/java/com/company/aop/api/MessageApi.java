package com.company.aop.api;

import com.company.aop.service.MessageService;
import com.company.aop.service.SecondMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    private final MessageService messageService;
    private final SecondMessageService secondMessageService;

    public MessageApi(MessageService messageService, SecondMessageService secondMessageService) {
        this.messageService = messageService;
        this.secondMessageService = secondMessageService;
    }

    @PostMapping
    public ResponseEntity<String> sampleMethod(@RequestBody String message) {
        secondMessageService.message(message);
        return ResponseEntity.ok(messageService.sendMessage(message));
    }
}
