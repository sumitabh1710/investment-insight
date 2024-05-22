package com.example.Investmentinsight.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.Investmentinsight.Dto.ChatRequest;
import com.example.Investmentinsight.Dto.ChatResponse;
import com.example.Investmentinsight.Dto.PromptDto;

@Service
public class GPT4Service {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${openai.model}")
    private String model;
    
    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public String chat(@RequestParam PromptDto prompt) {
        // create a request
        ChatRequest request = new ChatRequest(model, prompt.getPrompt());
        
        // call the API
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        return response.getChoices().get(0).getMessage().getContent();
    }

}
