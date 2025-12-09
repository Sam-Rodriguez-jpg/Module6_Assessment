package com.coopcredit.credit_application_service.domain.models;

public class RiskEvaluation {
    private Long id;
    private Integer score;  // Puntuación de riesgo
    private RiskLevel level;  // Nivel de riesgo (ALTO, MEDIO, BAJO)
    private String description;  // Descripción de la evaluación
    private CreditApplication creditApplication;  // Relación con la solicitud de crédito

    public RiskEvaluation(Long id, Integer score, RiskLevel level, String description, CreditApplication creditApplication) {
        this.id = id;
        this.score = score;
        this.level = level;
        this.description = description;
        this.creditApplication = creditApplication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public RiskLevel getLevel() {
        return level;
    }

    public void setLevel(RiskLevel level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreditApplication getCreditApplication() {
        return creditApplication;
    }

    public void setCreditApplication(CreditApplication creditApplication) {
        this.creditApplication = creditApplication;
    }

    public enum RiskLevel {
        HIGH, MEDIUM, LOW
    }
}
