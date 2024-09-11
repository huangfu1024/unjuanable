package com.hf.left.domain.orgmng.org;

import com.hf.left.domain.tenantmng.TenantValidator;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/10 11:53
 * @version: 1.0
 */
@Component
public class OrgHandler {

    private final TenantValidator tenantValidator;

    private final CancelValidator cancleValidator;

    @Autowired
    public OrgHandler(TenantValidator tenantValidator, CancelValidator cancleValidator){
        this.tenantValidator = tenantValidator;
        this.cancleValidator = cancleValidator;
    }

    public void updateBasic(Org org, String newName, Long newLeader, Long userId){
        updateName(org, newName);
        updateLeader(org, newLeader);
        updateAuditInfo(org, userId);
    }

    public void cancel(Org org, Long userId){
        cancleValidator.orgToBeCanceledShouldNotHasEmp(org.getTenantId(), org.getId());
        org.cancel();
        updateAuditInfo(org, userId);
    }

    private void updateAuditInfo(Org org, Long userId) {
    }

    private void updateLeader(Org org, Long newLeader) {
        
    }

    private void updateName(Org org, String newName) {
        
    }

}
