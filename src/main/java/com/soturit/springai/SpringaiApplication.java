package com.soturit.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
		return args -> {
			ChatClient chatClient = builder.build();
			String response = chatClient.prompt(
					"Give me 5 video idea for my youtube channel focused on programming and AI with sarcastic side to it")
					.call().content();
			System.out.println(response);
		};
	}

}
