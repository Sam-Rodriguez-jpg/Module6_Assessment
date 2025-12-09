package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.adapters;

import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;
import com.coopcredit.credit_application_service.domain.ports.out.RiskEvaluationRepositoryPort;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.RiskEvaluationEntity;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.repository.RiskEvaluationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RiskEvaluationRepositoryAdapter implements RiskEvaluationRepositoryPort {

    private final RiskEvaluationRepository riskEvaluationRepository;

    public RiskEvaluationRepositoryAdapter(RiskEvaluationRepository riskEvaluationRepository) {
        this.riskEvaluationRepository = riskEvaluationRepository;
    }

    @Override
    public void save(RiskEvaluation riskEvaluation) {
        // Convertir RiskEvaluation a RiskEvaluationEntity antes de guardarlo
        RiskEvaluationEntity riskEvaluationEntity = new RiskEvaluationEntity();
        // Mapea de RiskEvaluation a RiskEvaluationEntity, por ejemplo:
        riskEvaluationEntity.setScore(riskEvaluation.getScore());
        riskEvaluationEntity.setLevel(riskEvaluation.getLevel());
        riskEvaluationEntity.setDescription(riskEvaluation.getDescription());

        riskEvaluationRepository.save(riskEvaluationEntity); // Guardar en la base de datos
    }
}
