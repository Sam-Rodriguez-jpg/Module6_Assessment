package com.coopcredit.credit_application_service.domain.ports.out;

import com.coopcredit.credit_application_service.domain.models.Affiliate;

public interface UpdateAffiliatePort {
    // Metodo para actualizar un afiliado
    void updateAffiliate(Affiliate affiliate);
}
