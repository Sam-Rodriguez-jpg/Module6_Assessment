package com.coopcredit.credit_application_service.domain.models;

import java.time.LocalDateTime;

public class CreditApplication {
    private Long id;
    private Double amount;  // Monto solicitado
    private Integer term;  // Plazo (en meses)
    private Double rate;  // Tasa propuesta
    private ApplicationStatus status;  // Estado de la solicitud (PENDIENTE, APROBADO, RECHAZADO)
    private LocalDateTime applicationDate;  // Fecha de solicitud
    private RiskEvaluation riskEvaluation;  // Relación con la evaluación de riesgo
    private Affiliate affiliate;  // Relación con el afiliado

    public CreditApplication(Long id, Double amount, Integer term, Double rate, ApplicationStatus status, LocalDateTime applicationDate, RiskEvaluation riskEvaluation, Affiliate affiliate) {
        this.id = id;
        this.amount = amount;
        this.term = term;
        this.rate = rate;
        this.status = status;
        this.applicationDate = applicationDate;
        this.riskEvaluation = riskEvaluation;
        this.affiliate = affiliate;
    }

    public CreditApplication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public RiskEvaluation getRiskEvaluation() {
        return riskEvaluation;
    }

    public void setRiskEvaluation(RiskEvaluation riskEvaluation) {
        this.riskEvaluation = riskEvaluation;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public enum ApplicationStatus {
        PENDING, APPROVED, REJECTED
    }

}
