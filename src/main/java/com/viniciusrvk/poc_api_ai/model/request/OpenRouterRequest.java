package com.viniciusrvk.poc_api_ai.model.request;

import lombok.Data;

import java.util.List;

@Data
public class OpenRouterRequest {
    private String model;
    private List<OpenRouterMessage> messages;
}
