package com.coopcredit.credit_application_service.domain.ports.out;


import com.coopcredit.credit_application_service.domain.models.CreditApplication;

import java.util.Optional;

public interface CreditApplicationRepositoryPort {
    Optional<CreditApplication> findById(Long id);  // Buscar por ID
    void save(CreditApplication creditApplication);  // Guardar una solicitud de crédito
}
