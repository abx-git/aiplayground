package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.ollama.OllamaChatClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OllamaServiceTest {

    @Mock
    private OllamaChatClient ollamaChatClient;

    @InjectMocks
    private OllamaService ollamaService;

    @Test
    void generate_shouldCallChatClientAndReturnResponse() {
        // Arrange
        String prompt = "Test prompt";
        String expectedResponse = "Test response";
        when(ollamaChatClient.call(prompt)).thenReturn(expectedResponse);

        // Act
        String actualResponse = ollamaService.generate(prompt);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(ollamaChatClient).call(prompt);
    }
}
