package com.viniciusrvk.poc_api_ai.controller;

import com.viniciusrvk.poc_api_ai.model.request.ChatRequest;
import com.viniciusrvk.poc_api_ai.model.response.ChatResponse;
import com.viniciusrvk.poc_api_ai.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.getChatResponse(request);
    }
}
