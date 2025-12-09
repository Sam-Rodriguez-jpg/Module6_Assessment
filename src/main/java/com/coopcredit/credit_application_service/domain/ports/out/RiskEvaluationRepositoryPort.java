package com.coopcredit.credit_application_service.domain.ports.out;

import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;

public interface RiskEvaluationRepositoryPort {
    // Guardar una evaluación de riesgo en la base de datos
    void save(RiskEvaluation riskEvaluation);
}