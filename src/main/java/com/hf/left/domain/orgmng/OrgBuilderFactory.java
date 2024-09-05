package com.hf.left.domain.orgmng;

import com.hf.left.domain.tenantmng.TenantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/5 13:59
 * @version: 1.0
 */
@Component
public class OrgBuilderFactory {

    private final TenantValidator tenantValidator;

    @Autowired
    public OrgBuilderFactory(TenantValidator tenantValidator){
        this.tenantValidator = tenantValidator;
    }

    public OrgBuilder create() {
        return new OrgBuilder(tenantValidator);
    }
}
