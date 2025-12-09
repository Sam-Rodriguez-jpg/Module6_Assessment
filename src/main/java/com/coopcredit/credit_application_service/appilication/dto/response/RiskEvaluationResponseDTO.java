package com.coopcredit.credit_application_service.appilication.dto.response;

import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;

public class RiskEvaluationResponseDTO {
    private Integer score;  // Puntuación de riesgo
    private String riskLevel;  // Nivel de riesgo (ALTO, MEDIO, BAJO) como String
    private String detail;  // Detalles de la evaluación

    public RiskEvaluationResponseDTO(Integer score, String riskLevel, String detail) {
        this.score = score;
        this.riskLevel = riskLevel;
        this.detail = detail;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
