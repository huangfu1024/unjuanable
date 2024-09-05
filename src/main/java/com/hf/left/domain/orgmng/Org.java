package com.hf.left.domain.orgmng;


import lombok.Data;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:52
 * @version: 1.0
 */
@Data
public class Org {

    private Long id;

    private Long tenantId;

    private Long orgTypeCode;

    private Long superiorId;

    private Long LeaderId;

    private String name;

    private OrgStatus status;

    private String createdAt;

    private Long createdBy;

    private String lastUpdatedAt;

    private Long lastUpdateBy;

    public Org(){
        status = OrgStatus.EFFECTIVE;
    }
}


