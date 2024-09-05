package com.hf.left.domain.orgmng;

import com.hf.left.application.orgmng.OrgDto;
import com.hf.left.domain.tenantmng.TenantValidator;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Builder;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/5 13:52
 * @version: 1.0
 */
public class OrgBuilder {

    private final TenantValidator tenantValidator;

    public OrgBuilder(TenantValidator tenantValidator){
        this.tenantValidator = tenantValidator;
    }

    private Long tenantId;

    private Long superiorId;

    private String orgTypeCode;

    private Long leaderId;

    private String name;

    private Long createdBy;

    public OrgBuilder tenantId(Long tenantId){
        this.tenantId = tenantId;
        return this;
    }

    public Org build(){
        this.validate();
        Org org = new Org();
        org.setTenantId(this.tenantId);
        return org;
    }

    public void validate() {
        //进行各种业务规则的校验，会用到上面的各个Repository...
        tenantValidator.tenantShouldVaild(tenantId);
    }
}
