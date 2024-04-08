package me.sathish.ai.fantasticoctowaffle;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class FantasticClient {
    private final OllamaChatClient ollamaChatClient;
    public FantasticClient(OllamaChatClient ollamaChatClient) {
        this.ollamaChatClient =ollamaChatClient;
    }
    public String call(String message) {
        Prompt prompt = new Prompt(message);
        ChatResponse response = ollamaChatClient.call(prompt);
        return response.getResults().get(0).toString();
    }
    public Flux<ChatResponse> stream(Prompt prompt) {
        return ollamaChatClient.stream(prompt);
    }

}
