package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.repository;

import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.AffiliateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AffiliateRepository extends JpaRepository<AffiliateEntity, Long> {
    Optional<AffiliateEntity> findByDocument(String document);
    Optional<AffiliateEntity> findById(Long id);
}

