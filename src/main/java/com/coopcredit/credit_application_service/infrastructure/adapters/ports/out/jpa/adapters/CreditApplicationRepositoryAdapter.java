package com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.adapters;

import com.coopcredit.credit_application_service.appilication.mappers.CreditApplicationMapper;
import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import com.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.entities.CreditApplicationEntity;
import com.coopcredit.credit_application_service.infrastructure.adapters.ports.out.jpa.repository.CreditApplicationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CreditApplicationRepositoryAdapter implements CreditApplicationRepositoryPort {

    private final CreditApplicationRepository creditApplicationRepository;
    private final CreditApplicationMapper creditApplicationMapper;

    public CreditApplicationRepositoryAdapter(CreditApplicationRepository creditApplicationRepository, CreditApplicationMapper creditApplicationMapper) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.creditApplicationMapper = creditApplicationMapper;
    }

    @Override
    public Optional<CreditApplication> findById(Long id) {
        // Obtener la entidad y mapearla al modelo de dominio
        Optional<CreditApplicationEntity> creditApplicationEntity = creditApplicationRepository.findById(id);
        return creditApplicationEntity.map(creditApplicationMapper::creditApplicationEntityToCreditApplication);
    }

    @Override
    public void save(CreditApplication creditApplication) {
        // Convertir de CreditApplication (dominio) a CreditApplicationEntity (entidad) antes de guardar
        CreditApplicationEntity creditApplicationEntity = creditApplicationMapper.creditApplicationToCreditApplicationEntity(creditApplication);
        creditApplicationRepository.save(creditApplicationEntity);
    }
}
