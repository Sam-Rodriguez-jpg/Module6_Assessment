package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities;

import com.coopcredit.credit_application_service.domain.models.Affiliate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "affiliates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Affiliate.AffiliateStatus status;  // Usamos `EnumType.STRING` para almacenar el valor del `ENUM` como string en la DB

    @Column(nullable = false)
    private LocalDateTime affiliationDate;

    @OneToMany(mappedBy = "affiliate")
    private List<CreditApplicationEntity> creditApplications;
}
