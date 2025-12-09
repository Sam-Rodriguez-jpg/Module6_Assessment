package com.coopcredit.credit_application_service.appilication.service;

import com.coopcredit.credit_application_service.appilication.dto.response.RiskEvaluationResponseDTO;
import com.coopcredit.credit_application_service.appilication.exceptions.CreditApplicationException;
import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;
import com.coopcredit.credit_application_service.domain.ports.in.EvaluateCreditApplicationPort;
import com.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import com.coopcredit.credit_application_service.domain.ports.out.RiskEvaluationClientPort;
import org.springframework.stereotype.Service;

@Service
public class EvaluateCreditApplicationUseCase implements EvaluateCreditApplicationPort {

    private final CreditApplicationRepositoryPort creditApplicationRepository;
    private final RiskEvaluationClientPort riskEvaluationClientPort;

    public EvaluateCreditApplicationUseCase(CreditApplicationRepositoryPort creditApplicationRepository, RiskEvaluationClientPort riskEvaluationClientPort) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.riskEvaluationClientPort = riskEvaluationClientPort;
    }

    @Override
    public void evaluateCreditApplication(Long creditApplicationId) {
        // Obtener la solicitud de crédito
        CreditApplication creditApplication = creditApplicationRepository.findById(creditApplicationId)
                .orElseThrow(() -> new CreditApplicationException("Solicitud de crédito no encontrada"));

        // Invocar al microservicio para obtener la evaluación de riesgo
        RiskEvaluationResponseDTO riskEvaluationResponse = riskEvaluationClientPort.evaluateRisk(
                creditApplication.getAffiliate().getDocument(),
                creditApplication.getAmount(),
                creditApplication.getTerm()
        );

        // Crear la evaluación de riesgo
        RiskEvaluation riskEvaluation = new RiskEvaluation(
                null,  // id no se necesita aquí, lo asignará la base de datos si es necesario
                riskEvaluationResponse.getScore(),
                RiskEvaluation.RiskLevel.valueOf(riskEvaluationResponse.getRiskLevel()), // Convertir de String a enum
                riskEvaluationResponse.getDetail(),
                creditApplication  // Asocia la evaluación con la solicitud de crédito
        );

        // Actualizar la solicitud con la evaluación
        creditApplication.setRiskEvaluation(riskEvaluation);

        // Actualizar el estado de la solicitud
        if (riskEvaluation.getLevel() == RiskEvaluation.RiskLevel.HIGH) {
            creditApplication.setStatus(CreditApplication.ApplicationStatus.REJECTED);
        } else {
            creditApplication.setStatus(CreditApplication.ApplicationStatus.APPROVED);
        }

        // Guardar la solicitud de crédito actualizada
        creditApplicationRepository.save(creditApplication);
    }
}
