package com.example.Investmentinsight.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "investmentInsights")
@Data
public class InvestmentInsight {

    @Id
    private String id;
    private String userId;
    private String insight;
}