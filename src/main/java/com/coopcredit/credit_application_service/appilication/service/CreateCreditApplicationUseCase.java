package com.coopcredit.credit_application_service.appilication.service;

import com.coopcredit.credit_application_service.appilication.exceptions.CreditApplicationException;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import com.coopcredit.credit_application_service.domain.ports.in.CreateCreditApplicationPort;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import com.coopcredit.credit_application_service.domain.ports.out.CreditApplicationRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCreditApplicationUseCase implements CreateCreditApplicationPort {

    private final CreditApplicationRepositoryPort creditApplicationRepository;
    private final AffiliateRepositoryPort affiliateRepository;

    public CreateCreditApplicationUseCase(CreditApplicationRepositoryPort creditApplicationRepository, AffiliateRepositoryPort affiliateRepository) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.affiliateRepository = affiliateRepository;
    }

    @Override
    public void createCreditApplication(CreditApplication creditApplication) {
        // Validar que el afiliado exista y esté activo
        if (creditApplication.getAffiliate() == null || creditApplication.getAffiliate().getStatus() != Affiliate.AffiliateStatus.ACTIVE) {
            throw new CreditApplicationException("El afiliado debe estar activo para solicitar crédito");
        }

        // Validar que el monto no supere el límite basado en el salario del afiliado
        if (creditApplication.getAmount() > creditApplication.getAffiliate().getSalary() * 10) {
            throw new CreditApplicationException("El monto solicitado excede el límite permitido");
        }

        // Guardar la solicitud de crédito
        creditApplicationRepository.save(creditApplication);
    }
}
