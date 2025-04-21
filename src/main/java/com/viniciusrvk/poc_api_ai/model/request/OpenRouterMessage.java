package com.viniciusrvk.poc_api_ai.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenRouterMessage {
    private String role;   // Ex: "user", "system", "assistant"
    private String content;
}
