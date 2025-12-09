package com.coopcredit.credit_application_service.infrastructure.adapters.ports.in.web.controller;

import com.coopcredit.credit_application_service.appilication.dto.request.AffiliateRequestDTO;
import com.coopcredit.credit_application_service.appilication.dto.request.CreditApplicationRequestDTO;
import com.coopcredit.credit_application_service.appilication.dto.response.AffiliateResponseDTO;
import com.coopcredit.credit_application_service.appilication.service.*;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.models.CreditApplication;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/affiliates")
public class AffiliateController {

    private final RegisterAffiliateUseCase registerAffiliateUseCase;
    private final UpdateAffiliateUseCase updateAffiliateUseCase;
    private final CreateCreditApplicationUseCase createCreditApplicationUseCase;
    private final EvaluateCreditApplicationUseCase evaluateCreditApplicationUseCase;
    private final GetAffiliateUseCase getAffiliateUseCase;

    public AffiliateController(
            RegisterAffiliateUseCase registerAffiliateUseCase,
            UpdateAffiliateUseCase updateAffiliateUseCase,
            CreateCreditApplicationUseCase createCreditApplicationUseCase,
            EvaluateCreditApplicationUseCase evaluateCreditApplicationUseCase,
            GetAffiliateUseCase getAffiliateUseCase) {
        this.registerAffiliateUseCase = registerAffiliateUseCase;
        this.updateAffiliateUseCase = updateAffiliateUseCase;
        this.createCreditApplicationUseCase = createCreditApplicationUseCase;
        this.evaluateCreditApplicationUseCase = evaluateCreditApplicationUseCase;
        this.getAffiliateUseCase = getAffiliateUseCase;
    }

    // Registrar un nuevo afiliado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAffiliate(@RequestBody AffiliateRequestDTO affiliateRequestDTO) {
        // Convertir la fecha del DTO (String) a LocalDateTime
        LocalDateTime affiliationDate = LocalDateTime.parse(affiliateRequestDTO.getAffiliationDate(), DateTimeFormatter.ISO_DATE_TIME);

        registerAffiliateUseCase.registerAffiliate(
                affiliateRequestDTO.getDocument(),
                affiliateRequestDTO.getName(),
                affiliateRequestDTO.getSalary(),
                affiliateRequestDTO.getStatus(),
                affiliationDate.toString()
        );
    }

    // Actualizar información de un afiliado
    @PutMapping("/{affiliateId}")
    public void updateAffiliate(@PathVariable Long affiliateId, @RequestBody AffiliateRequestDTO affiliateRequestDTO) {
        Affiliate existingAffiliate = getAffiliateUseCase.getAffiliateById(affiliateId);

        // Convertir la fecha del DTO (String) a LocalDateTime
        LocalDateTime affiliationDate = LocalDateTime.parse(affiliateRequestDTO.getAffiliationDate(), DateTimeFormatter.ISO_DATE_TIME);

        existingAffiliate.setDocument(affiliateRequestDTO.getDocument());
        existingAffiliate.setName(affiliateRequestDTO.getName());
        existingAffiliate.setSalary(affiliateRequestDTO.getSalary());
        existingAffiliate.setStatus(affiliateRequestDTO.getStatus());
        existingAffiliate.setAffiliationDate(String.valueOf(affiliationDate));

        updateAffiliateUseCase.updateAffiliate(existingAffiliate);
    }

    // Crear una solicitud de crédito
    @PostMapping("/{affiliateId}/credit-application")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCreditApplication(@PathVariable Long affiliateId, @RequestBody CreditApplicationRequestDTO creditApplicationRequestDTO) {
        Affiliate affiliate = getAffiliateUseCase.getAffiliateById(affiliateId);

        CreditApplication creditApplication = new CreditApplication(
                null,
                affiliate,
                creditApplicationRequestDTO.getAmount(),
                creditApplicationRequestDTO.getTerm(),
                CreditApplication.ApplicationStatus.PENDING
        );

        createCreditApplicationUseCase.createCreditApplication(creditApplication);
    }

    // Evaluar la solicitud de crédito
    @PutMapping("/credit-application/{creditApplicationId}/evaluate")
    public void evaluateCreditApplication(@PathVariable Long creditApplicationId) {
        evaluateCreditApplicationUseCase.evaluateCreditApplication(creditApplicationId);
    }

    // Obtener la información de un afiliado
    @GetMapping("/{affiliateId}")
    public AffiliateResponseDTO getAffiliate(@PathVariable Long affiliateId) {
        Affiliate affiliate = getAffiliateUseCase.getAffiliateById(affiliateId);

        String formattedDate = affiliate.getAffiliationDate().format(DateTimeFormatter.ISO_DATE_TIME);

        return new AffiliateResponseDTO(
                affiliate.getDocument(),
                affiliate.getName(),
                affiliate.getSalary(),
                affiliate.getStatus(),
                formattedDate
        );
    }
}
