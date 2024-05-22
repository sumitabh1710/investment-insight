package com.example.Investmentinsight.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Investmentinsight.Document.InvestmentInsight;
import com.example.Investmentinsight.Document.User;
import com.example.Investmentinsight.Dto.PromptDto;
import com.example.Investmentinsight.Repository.InvestmentInsightRepository;
import com.example.Investmentinsight.Repository.UserRepository;

@Service
public class InvestmentInsightService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GPT4Service gpt4Service;

    @Autowired
    private InvestmentInsightRepository investmentInsightRepository;

    public InvestmentInsight generateInsight(String username, PromptDto prompt) {
        try {
            Optional<User> user = userRepository.findByUsername(username);

            if (user.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            String customizedPrompt = "Based on your preferences:\n";

            String userPreference = user.get().getPreference();
            if (userPreference != null && !userPreference.isEmpty()) {
                customizedPrompt += "Preferred sectors: " + userPreference + "\n";
            }

            customizedPrompt += "\n" + prompt.getPrompt();

            System.out.println(customizedPrompt);

            String insight = gpt4Service.chat(prompt);
            System.out.printf("insight", insight);
            InvestmentInsight investmentInsight = new InvestmentInsight();
            investmentInsight.setUserId(username);
            investmentInsight.setInsight(insight);
            return investmentInsightRepository.save(investmentInsight);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error occurred: " + e.getMessage());
        }
    }

    public List<InvestmentInsight> getUserInsights(String userId) {
        return investmentInsightRepository.findByUserId(userId);
    }
}
