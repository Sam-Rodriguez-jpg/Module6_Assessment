package com.coopcredit.credit_application_service.domain.ports.in;

import com.coopcredit.credit_application_service.domain.models.CreditApplication;

public interface CreateCreditApplicationPort {
    void createCreditApplication(CreditApplication creditApplication);
}
