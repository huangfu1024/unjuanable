package com.hf.left.application.orgmng;

import lombok.Data;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/5 11:26
 * @version: 1.0
 */
@Data
public class OrgResponse {

    private Long id;

    private Long tenantId;

    private Long orgTypeCode;

    private Long superiorId;

    private Long LeaderId;

    private String name;

    private String status;

    private String createdAt;

    private Long createdBy;

    private String lastUpdatedAt;

    private Long lastUpdateBy;

}
