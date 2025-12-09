package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities;

import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "risk_evaluations")
@Data
public class RiskEvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer score;  // Puntuación de riesgo

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiskEvaluation.RiskLevel level;  // Nivel de riesgo (ALTO, MEDIO, BAJO)

    @Column(nullable = false)
    private String description;  // Descripción de la evaluación

    @OneToOne
    @JoinColumn(name = "credit_application_id", nullable = false)
    private CreditApplicationEntity creditApplication;  // Relación con la solicitud de crédito

    // Constructor por defecto (esto es necesario para JPA)
    public RiskEvaluationEntity() {
    }

    // Constructor con todos los parámetros
    public RiskEvaluationEntity(Long id, Integer score, RiskEvaluation.RiskLevel level, String description, CreditApplicationEntity creditApplication) {
        this.id = id;
        this.score = score;
        this.level = level;
        this.description = description;
        this.creditApplication = creditApplication;
    }

    // Métodos setters y getters
    public void setScore(Integer score) {
        this.score = score;
    }

    public void setLevel(RiskEvaluation.RiskLevel level) {
        this.level = level;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditApplication(CreditApplicationEntity creditApplication) {
        this.creditApplication = creditApplication;
    }
}