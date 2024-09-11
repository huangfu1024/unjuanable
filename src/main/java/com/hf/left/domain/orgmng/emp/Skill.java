package com.hf.left.domain.orgmng.emp;

import com.hf.left.common.framework.AuditableEntity;

import java.time.LocalDateTime;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/11 13:44
 * @version: 1.0
 */
public class Skill extends AuditableEntity {

    private Long id;

    private Long tenantId;

    private Long skillTypeId;

    SkillLevel level;

    private int duration;

    Skill(Long tenantId, Long skillTypeId, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.tenantId = tenantId;
        this.skillTypeId = skillTypeId;
    }

    public Long getId(){
        return id;
    }

    public Long getSkillTypeId() {
        return skillTypeId;
    }

    public SkillLevel getLevel() {
        return level;
    }

    // 包级私有权限
    void setLevel(SkillLevel level) {
        this.level = level;
    }

    public int getDuration() {
        return duration;
    }

    // 包级私有权限
    void setDuration(int duration) {
        this.duration = duration;
    }




}
