package com.coopcredit.credit_application_service.appilication.service;

import com.coopcredit.credit_application_service.appilication.exceptions.AffiliateException;
import com.coopcredit.credit_application_service.domain.models.Affiliate;
import com.coopcredit.credit_application_service.domain.ports.in.RegisterAffiliatePort;
import com.coopcredit.credit_application_service.domain.ports.out.AffiliateRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RegisterAffiliateUseCase {

    private final AffiliateRepositoryPort affiliateRepository;

    public RegisterAffiliateUseCase(AffiliateRepositoryPort affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }

    public void registerAffiliate(String document, String name, Double salary, String status, String affiliationDate) {
        // Validar el documento
        if (affiliateRepository.findByDocument(document) != null) {
            throw new AffiliateException("El documento ya está registrado");
        }

        // Validar el salario
        if (salary <= 0) {
            throw new AffiliateException("El salario debe ser mayor a 0");
        }

        // Validar el estado
        if (status == null || !status.equalsIgnoreCase("ACTIVE")) {
            throw new AffiliateException("El afiliado debe estar activo para registrarse");
        }

        // Log para ver la fecha recibida
        System.out.println("Fecha de afiliación recibida: " + affiliationDate);

        // Convertir la fecha del DTO a LocalDateTime
        LocalDateTime affiliationDateTime = parseAffiliationDate(affiliationDate);

        // Asegurarse de que affiliationDateTime no sea null
        if (affiliationDateTime == null) {
            throw new AffiliateException("La fecha de afiliación no es válida");
        }

        // Crear el afiliado
        Affiliate affiliate = new Affiliate(null, document, name, salary, Affiliate.AffiliateStatus.ACTIVE, affiliationDateTime, null);

        // Guardar el afiliado en la base de datos
        affiliateRepository.save(affiliate);
    }

    private LocalDateTime parseAffiliationDate(String affiliationDate) {
        try {
            // Usar un DateTimeFormatter que se ajuste al formato esperado
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;  // Ajustar si el formato es otro
            return LocalDateTime.parse(affiliationDate, formatter);
        } catch (Exception e) {
            // Log para ver más detalles del error
            System.err.println("Error al convertir la fecha: " + e.getMessage());
            throw new AffiliateException("Fecha de afiliación inválida. El formato esperado es: yyyy-MM-dd'T'HH:mm:ss");
        }
    }
}