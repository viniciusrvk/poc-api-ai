package com.viniciusrvk.poc_api_ai.service;

import com.viniciusrvk.poc_api_ai.client.OpenRouterClient;
import com.viniciusrvk.poc_api_ai.model.request.ChatRequest;
import com.viniciusrvk.poc_api_ai.model.response.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final OpenRouterClient openRouterClient;

    public ChatResponse getChatResponse(ChatRequest request) {
        return openRouterClient.callOpenRouter(request.getMessage());
    }
}
