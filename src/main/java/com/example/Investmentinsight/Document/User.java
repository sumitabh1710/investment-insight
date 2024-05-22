package com.example.Investmentinsight.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "userPreferences")
@Builder
@Data
public class User {

    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    private String preference;
    private boolean active;
}

