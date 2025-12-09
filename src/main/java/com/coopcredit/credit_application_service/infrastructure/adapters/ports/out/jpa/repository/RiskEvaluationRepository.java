package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.repository;

import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.RiskEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskEvaluationRepository extends JpaRepository<RiskEvaluationEntity, Long> {
}
