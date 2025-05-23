package com.example.demo;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

    private final OllamaChatClient ollamaChatClient;

    public OllamaService(OllamaChatClient ollamaChatClient) {
        this.ollamaChatClient = ollamaChatClient;
    }

    public String generate(String prompt) {
        return ollamaChatClient.call(prompt);
    }
}
