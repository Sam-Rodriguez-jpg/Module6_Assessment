package com.coopcredit.credit_application_service.domain.models;

import java.time.LocalDateTime;
import java.util.List;

public class Affiliate {
    private Long id;
    private String document;  // Documento único del afiliado
    private String name;  // Nombre del afiliado
    private Double salary;  // Salario del afiliado
    private AffiliateStatus status;  // Estado (ACTIVO / INACTIVO)
    private String affiliationDate;  // Fecha de afiliación
    private List<CreditApplication> creditApplications;  // Listado de solicitudes de crédito

    public Affiliate(Long id, String document, String name, Double salary, AffiliateStatus status, LocalDateTime affiliationDate, List<CreditApplication> creditApplications) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.affiliationDate = affiliationDate;
        this.creditApplications = creditApplications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AffiliateStatus getStatus() {
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

    public List<CreditApplication> getCreditApplications() {
        return creditApplications;
    }

    public void setCreditApplications(List<CreditApplication> creditApplications) {
        this.creditApplications = creditApplications;
    }

    public enum AffiliateStatus {
        ACTIVE, INACTIVE
    }
}
