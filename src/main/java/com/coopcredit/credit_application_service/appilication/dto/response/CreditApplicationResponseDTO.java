package com.coopcredit.credit_application_service.appilication.dto.response;

import com.coopcredit.credit_application_service.domain.models.CreditApplication;

public class CreditApplicationResponseDTO {
    private Double amount;   // Monto solicitado
    private Integer term;    // Plazo en meses
    private Double rate;     // Tasa propuesta
    private String applicationDate;  // Fecha de solicitud (como String)
    private CreditApplication.ApplicationStatus status;   // Estado de la solicitud (PENDIENTE, APROBADO, RECHAZADO)

    public CreditApplicationResponseDTO(Double amount, Integer term, Double rate, String applicationDate, CreditApplication.ApplicationStatus status) {
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

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public CreditApplication.ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(CreditApplication.ApplicationStatus status) {
        this.status = status;
    }
}
