package com.coopcredit.credit_application_service.domain.ports.out;

import com.coopcredit.credit_application_service.appilication.dto.response.RiskEvaluationResponseDTO;

public interface RiskEvaluationClientPort {

    RiskEvaluationResponseDTO evaluateRisk(String document, Double amount, Integer term);
}
