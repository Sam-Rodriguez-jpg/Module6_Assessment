package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.adapters;

import com.coopcredit.credit_application_service.appilication.mappers.AffiliateMapper;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.AffiliateEntity;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.repository.AffiliateRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AffiliateRepositoryAdapter implements AffiliateRepositoryPort {

    private final AffiliateRepository affiliateRepository;
    private final AffiliateMapper affiliateMapper;  // Mapper para convertir entre AffiliateEntity y Affiliate

    public AffiliateRepositoryAdapter(AffiliateRepository affiliateRepository, AffiliateMapper affiliateMapper) {
        this.affiliateRepository = affiliateRepository;
        this.affiliateMapper = affiliateMapper;
    }

    @Override
    public Optional<Affiliate> findById(Long id) {
        return affiliateRepository.findById(id).map(affiliateMapper::toDomain); // Conversión a modelo de dominio
    }

    @Override
    public Optional<Affiliate> findByDocument(String document) {
        return affiliateRepository.findByDocument(document).map(affiliateMapper::toDomain); // Conversión a modelo de dominio
    }

    @Override
    public void save(Affiliate affiliate) {
        AffiliateEntity affiliateEntity = affiliateMapper.toEntity(affiliate); // Convertir a entidad
        affiliateRepository.save(affiliateEntity);
    }

    @Override
    public void update(Affiliate affiliate) {
        AffiliateEntity affiliateEntity = affiliateMapper.toEntity(affiliate); // Convertir a entidad
        affiliateRepository.save(affiliateEntity);  // Usamos save() porque JPA realiza un merge en lugar de un insert
    }
}
