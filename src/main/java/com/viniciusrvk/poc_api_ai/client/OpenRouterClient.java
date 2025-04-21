package com.viniciusrvk.poc_api_ai.client;

import com.viniciusrvk.poc_api_ai.config.OpenRouterConfig;
import com.viniciusrvk.poc_api_ai.model.request.OpenRouterMessage;
import com.viniciusrvk.poc_api_ai.model.request.OpenRouterRequest;
import com.viniciusrvk.poc_api_ai.model.response.ChatResponse;
import com.viniciusrvk.poc_api_ai.model.response.OpenRouterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class OpenRouterClient {

    private final OpenRouterConfig openRouterConfig;
    private final WebClient webClient = WebClient.builder().build();

    public ChatResponse callOpenRouter(String userMessage) {
        // Monta o payload
        OpenRouterRequest request = new OpenRouterRequest();
        request.setModel(openRouterConfig.getModel());
        request.setMessages(Collections.singletonList(
                new OpenRouterMessage("user", userMessage)
        ));

        // Faz a chamada para o OpenRouter
        OpenRouterResponse response = webClient.post()
                .uri(openRouterConfig.getBaseUrl()+openRouterConfig.getPath())
                .header("Authorization", "Bearer " + openRouterConfig.getApiKey())
                .body(Mono.just(request), OpenRouterRequest.class)
                .retrieve()
                .bodyToMono(OpenRouterResponse.class)
                .block(); // -> como é prova de conceito, pode usar block()

        // Extrai a resposta principal do modelo
        String content = response.getChoices().get(0).getMessage().getContent();

        return new ChatResponse(content);
    }
}