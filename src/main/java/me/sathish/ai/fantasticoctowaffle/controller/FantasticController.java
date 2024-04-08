package me.sathish.ai.fantasticoctowaffle.controller;

import me.sathish.ai.fantasticoctowaffle.FantasticClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class FantasticController {
    private final FantasticClient chatClient;

    @Autowired
    public FantasticController(FantasticClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "What is your name") String message) {
        long startTime = System.nanoTime();

        // method to be timed
        String output= chatClient.call(message);
        System.out.println("The output is " + output);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // compute time elapsed
        System.out.println("Execution time in nanoseconds: " + duration);
        System.out.println("Execution time in milliseconds: " + duration / 1000000);
        return Map.of("generation", output, "duration milliseconds", duration / 1000000);
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "What is your name") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.stream(prompt);
    }
}
