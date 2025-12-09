package com.coopcredit.credit_application_service.appilication.mappers;

import com.coopcredit.credit_application_service.appilication.dto.response.RiskEvaluationResponseDTO;
import com.coopcredit.credit_application_service.domain.models.RiskEvaluation;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.RiskEvaluationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CreditApplicationMapper.class})
public interface RiskEvaluationMapper {

    // Mapea de la entidad `RiskEvaluationEntity` al modelo de dominio `RiskEvaluation`
    RiskEvaluation riskEvaluationEntityToRiskEvaluation(RiskEvaluationEntity riskEvaluationEntity);

    // Mapea del modelo de dominio `RiskEvaluation` a la entidad `RiskEvaluationEntity`
    @Mappings({
            @Mapping(source = "creditApplication", target = "creditApplication")
    })
    RiskEvaluationEntity riskEvaluationToRiskEvaluationEntity(RiskEvaluation riskEvaluation);

    // Mapea de `RiskEvaluation` a `RiskEvaluationResponseDTO`
    RiskEvaluationResponseDTO riskEvaluationToRiskEvaluationResponseDTO(RiskEvaluation riskEvaluation);
}
