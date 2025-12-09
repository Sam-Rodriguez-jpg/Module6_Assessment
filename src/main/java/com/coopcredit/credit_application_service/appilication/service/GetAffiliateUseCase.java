package com.coopcredit.credit_application_service.appilication.service;

import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class GetAffiliateUseCase {

    private final AffiliateRepositoryPort affiliateRepository;

    public GetAffiliateUseCase(AffiliateRepositoryPort affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }

    public Affiliate getAffiliateById(Long affiliateId) {
        return affiliateRepository.findById(affiliateId)
                .orElseThrow(() -> new RuntimeException("Afiliado no encontrado"));
    }
}
