package com.coopcredit.credit_application_service.appilication.dto.request;

import com.coopcredit.credit_application_service.domain.models.CreditApplication;

import java.time.LocalDateTime;

public class CreditApplicationRequestDTO {
    private Double amount;   // Monto solicitado
    private Integer term;    // Plazo en meses
    private Double rate;     // Tasa propuesta
    private LocalDateTime applicationDate;  // Fecha de solicitud
    private String status;   // Estado de la solicitud (PENDIENTE, APROBADO, RECHAZADO) como String

    public CreditApplicationRequestDTO(Double amount, Integer term, Double rate, LocalDateTime applicationDate, String status) {
        this.amount = amount;
        this.term = term;
        this.rate = rate;
        this.applicationDate = applicationDate;
        this.status = status;
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

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
