package com.hf.left.domain.orgmng.org;


import com.hf.left.common.framework.AuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:52
 * @version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Org extends AuditableEntity {

    private Long id;

    private Long tenantId;

    private Long orgTypeCode;

    private Long superiorId;

    private Long LeaderId;

    private String name;

    private OrgStatus status;

    public Org(){
        status = OrgStatus.EFFECTIVE;
    }

    public boolean OnlyEffectiveOrgCanBeCancelled(Org org){
        return status.equals(OrgStatus.EFFECTIVE);
    }

    public void cancel(){
        this.status = OrgStatus.CANCEL;
    }
}


