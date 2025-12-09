package com.coopcredit.credit_application_service.appilication.mappers;

import com.coopcredit.credit_application_service.appilication.dto.request.AffiliateRequestDTO;
import com.coopcredit.credit_application_service.appilication.dto.response.AffiliateResponseDTO;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.AffiliateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AffiliateMapper {

    // Mapea de la entidad `AffiliateEntity` al modelo de dominio `Affiliate`
    Affiliate toDomain(AffiliateEntity affiliateEntity);

    // Mapea del modelo de dominio `Affiliate` a la entidad `AffiliateEntity`
    AffiliateEntity toEntity(Affiliate affiliate);

    // Mapea de `AffiliateRequestDTO` a `Affiliate` (convierte un DTO de solicitud a un modelo de dominio)
    Affiliate toDomain(AffiliateRequestDTO affiliateRequestDTO);

    // Mapea de `Affiliate` a `AffiliateResponseDTO` (convierte un modelo de dominio a un DTO de respuesta)
    AffiliateResponseDTO toResponseDTO(Affiliate affiliate);
}
