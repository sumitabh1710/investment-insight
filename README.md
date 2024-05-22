InvestmentInsight Backend Documentation

**Overview**
The InvestmentInsight backend is a Spring Boot application designed to provide investment insights based on user preferences. It integrates with the OpenAI API to generate insights and includes user authentication and preference management.

**Technologies Used**
  1. Java
  2. Spring Boot
  3. Spring Security
  4. Spring Data MongoDB
  5. OpenAI API
  6. Lombok

**Setup Instructions**

1. Clone the Repository

  git clone https://github.com/sumitabh1710/investment-insight
  cd investment-insight

2. Configure Environment Variables
   
  spring.data.mongodb.uri=mongodb://localhost:27017/investmentinsight
  openai.api.key=your_openai_api_key_here

3. Build and Run the Application

  ./mvnw clean install
  ./mvnw spring-boot:run

   
   
