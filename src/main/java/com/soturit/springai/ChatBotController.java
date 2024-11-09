package com.soturit.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {
    private final ChatClient.Builder chatClientBuilder;

    public ChatBotController(ChatClient.Builder chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    @GetMapping("/chatthatforgets")
    public ChatBotResponse getChatThatForgetsResponse(@RequestParam String prompt) {
        var chatClient = chatClientBuilder.build();
        return new ChatBotResponse(chatClient.prompt(prompt).call().content());
    }

}
