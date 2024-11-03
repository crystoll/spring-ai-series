package com.soturit.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GrumpyDeveloperService {
    private final ChatClient.Builder chatClientBuilder;

    public GrumpyDeveloperService(ChatClient.Builder chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    public String getExcuse() {
        var chatClient = chatClientBuilder.build();
        return chatClient.prompt("Give me a sarcastic excuse for missing a deadline.").call().content();
    }

    public String getExcuseFor(String reason) {
        var chatClient = chatClientBuilder.build();
        var prompt = String.format("Give me a sarcastic excuse for %s.", reason);
        return chatClient.prompt(prompt).call().content();
    }
}