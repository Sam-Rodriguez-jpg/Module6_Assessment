package com.coopcredit.credit_application_service.appilication.service;

import com.coopcredit.credit_application_service.appilication.exceptions.AffiliateNotFoundException;
import com.coopcredit.credit_application_service.appilication.exceptions.InvalidAffiliateDataException;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateAffiliateUseCase {

    private final AffiliateRepositoryPort affiliateRepository;

    public UpdateAffiliateUseCase(AffiliateRepositoryPort affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }

    public void updateAffiliate(Affiliate affiliate) {
        Optional<Affiliate> existingAffiliate = affiliateRepository.findById(affiliate.getId());
        if (existingAffiliate.isEmpty()) {
            throw new RuntimeException("Afiliado no encontrado");
        }

        // Aquí puedes agregar lógica de validación adicional, si es necesario
        affiliateRepository.save(affiliate);
    }
}
