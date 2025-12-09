package com.coopcredit.credit_application_service.appilication.dto.request;


import com.coopcredit.credit_application_service.domain.models.Affiliate;

public class AffiliateRequestDTO {

    private String document;
    private String name;
    private Double salary;
    private AffiliateStatus status;
    private String affiliationDate; // Cambié de LocalDateTime a String para entrada desde API

    // Getters y Setters

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Affiliate.AffiliateStatus getStatus() {
        return status;
    }

    public void setStatus(AffiliateStatus status) {
        this.status = status;
    }

    public String getAffiliationDate() {
        return affiliationDate;
    }

    public void setAffiliationDate(String affiliationDate) {
        this.affiliationDate = affiliationDate;
    }

    public enum AffiliateStatus {
        ACTIVE, INACTIVE
    }
}
