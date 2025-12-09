package com.coopcredit.credit_application_service.appilication.dto.response;

import com.coopcredit.credit_application_service.domain.models.Affiliate;


public class AffiliateResponseDTO {

    private String document;
    private String name;
    private Double salary;
    private Affiliate.AffiliateStatus status;
    private String affiliationDate; // Ahora es un String para fecha

    public AffiliateResponseDTO(String document, String name, Double salary, Affiliate.AffiliateStatus status, String affiliationDate) {
        this.document = document;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.affiliationDate = affiliationDate;
    }

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

    public void setStatus(Affiliate.AffiliateStatus status) {
        this.status = status;
    }

    public String getAffiliationDate() {
        return affiliationDate;
    }

    public void setAffiliationDate(String affiliationDate) {
        this.affiliationDate = affiliationDate;
    }
}