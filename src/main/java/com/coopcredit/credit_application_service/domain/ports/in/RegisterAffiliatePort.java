package com.coopcredit.credit_application_service.domain.ports.in;

import com.coopcredit.credit_application_service.domain.models.Affiliate;

public interface RegisterAffiliatePort {
    void registerAffiliate(Affiliate affiliate);
}
