package com.soturit.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {
    private final ChatClient chatClient;

    public ChatBotController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
        .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))// CHAT MEMORY
        .build();
    }

    @GetMapping("/chat")
    public ChatBotResponse getChatResponse(@RequestParam String prompt) {
        return new ChatBotResponse(chatClient.prompt(prompt).call().content());
    }

}
