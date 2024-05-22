package com.example.Investmentinsight.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Investmentinsight.Document.InvestmentInsight;
import com.example.Investmentinsight.Dto.PromptDto;
import com.example.Investmentinsight.Service.InvestmentInsightService;

@RestController
@RequestMapping("/api/insights")
public class InvestmentInsightController {

    @Autowired
    private InvestmentInsightService investmentInsightService;

    @PostMapping("/{userId}")
    public InvestmentInsight generateInsight(@PathVariable String userId, @RequestBody PromptDto prompt) {
        return investmentInsightService.generateInsight(userId, prompt);
    }

    @GetMapping("/{userId}")
    public List<InvestmentInsight> getUserInsights(@PathVariable String userId) {
        return investmentInsightService.getUserInsights(userId);
    }
}