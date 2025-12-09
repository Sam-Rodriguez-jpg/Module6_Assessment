package com.coopcredit.credit_application_service.appilication.mappers;

import com.coopcredit.credit_application_service.appilication.dto.request.CreditApplicationRequestDTO;
import com.coopcredit.credit_application_service.appilication.dto.response.CreditApplicationResponseDTO;
import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.CreditApplicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {

    // Mapea CreditApplication a CreditApplicationEntity
    CreditApplicationEntity creditApplicationToCreditApplicationEntity(CreditApplication creditApplication);

    // Mapea CreditApplicationEntity a CreditApplication
    CreditApplication creditApplicationEntityToCreditApplication(CreditApplicationEntity creditApplicationEntity);
}
