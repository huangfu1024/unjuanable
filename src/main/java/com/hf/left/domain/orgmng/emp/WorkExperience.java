package com.hf.left.domain.orgmng.emp;

import com.hf.left.common.framework.AuditableEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/11 13:56
 * @version: 1.0
 */
public class WorkExperience extends AuditableEntity {

    private Long id;

    private Long tenantId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String company;

    public WorkExperience(Long tenantId, LocalDate startDate, LocalDate endDate, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantId = tenantId;
    }

    void setCompany(String company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCompany() {
        return company;
    }
}
