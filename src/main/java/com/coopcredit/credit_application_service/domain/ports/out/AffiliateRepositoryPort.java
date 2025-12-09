package com.coopcredit.credit_application_service.domain.ports.out;

import com.coopcredit.credit_application_service.domain.models.Affiliate;

import java.util.Optional;

public interface AffiliateRepositoryPort {
    Optional<Affiliate> findById(Long id); // Buscar un afiliado por ID
    Optional<Affiliate> findByDocument(String document); // Buscar un afiliado por documento
    void save(Affiliate affiliate); // Guardar un afiliado
    void update(Affiliate affiliate); // Actualizar un afiliado
}

