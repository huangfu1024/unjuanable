package com.hf.left.common.framework;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/10 12:11
 * @version: 1.0
 */
@Data
public abstract class AuditableEntity {

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime lastUpdatedAt;

    private Long lastUpdateBy;

    public AuditableEntity(LocalDateTime createdAt, Long createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}
