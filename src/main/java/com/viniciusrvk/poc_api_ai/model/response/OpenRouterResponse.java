package com.viniciusrvk.poc_api_ai.model.response;

import lombok.Data;

import java.util.List;

@Data
public class OpenRouterResponse {
    private List<OpenRouterChoice> choices;
}
