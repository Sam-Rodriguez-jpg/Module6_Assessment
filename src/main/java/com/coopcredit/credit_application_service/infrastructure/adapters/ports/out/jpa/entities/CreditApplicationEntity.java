package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities;

import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "credit_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "affiliate_id", nullable = false)
    private AffiliateEntity affiliate;  // Relación con la entidad AffiliateEntity

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Double rate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreditApplication.ApplicationStatus status;

    @Column(nullable = false)
    private LocalDateTime applicationDate;

    @OneToOne(mappedBy = "creditApplication")
    private RiskEvaluationEntity riskEvaluation;

}
