package com.example.Investmentinsight.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Investmentinsight.Document.InvestmentInsight;

public interface InvestmentInsightRepository extends MongoRepository<InvestmentInsight, String> {
    List<InvestmentInsight> findByUserId(String userId);
}
