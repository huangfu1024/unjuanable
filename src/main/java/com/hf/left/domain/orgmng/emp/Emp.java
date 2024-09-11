package com.hf.left.domain.orgmng.emp;

import com.hf.left.common.framework.AuditableEntity;
import com.hf.left.common.framework.BusinessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.hf.left.domain.orgmng.emp.EmpStatus.PROBATION;
import static com.hf.left.domain.orgmng.emp.EmpStatus.TERMINATED;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:51
 * @version: 1.0
 */
public class Emp extends AuditableEntity {

    private Long id; // 只读
    private Long tenantId; // 只读
    private Long orgId; // 读写
    private String num; // 读写，员工编号
    private String idNum; // 读写，身份证号
    private Gender Gender; // 读写
    private LocalDate dob; // 读写
    private EmpStatus status; // 读写
    private List<Skill> skills; // 读写
    private List<WorkExperience> experiences;// 读写
    private List<String> postCodes;

    public Emp(Long tenantId, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.tenantId= tenantId;
    }

    public EmpStatus getStatus(){
        return status;
    }

    public void becomeRegular() throws BusinessException {
        onlyProbationCanBecomeRegular();
        status = EmpStatus.REGULAR;
    }

    public void terminate() throws BusinessException {
        shouldNotTerminateAgain();
        status = TERMINATED;
    }

    public Optional<Skill> getSkill(Long skillTypeId) {
        return skills.stream()
                .filter(s -> s.getSkillTypeId() == skillTypeId)
                .findAny();
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public void addSkill(Long skillTypeId, SkillLevel level
            , int duration, Long userId) throws BusinessException {
        // 调用业务规则: 同一技能不能录入两次
        skillTypeShouldNotDuplicated(skillTypeId);
        Skill newSkill = new Skill(tenantId, skillTypeId, LocalDateTime.now(),  userId);
        newSkill.setLevel(level);
        newSkill.setDuration(duration);
        skills.add(newSkill);
    }

    public void addExperience(LocalDate startDate, LocalDate endDate, String company, Long userId) throws BusinessException {
        // 调用业务规则: 工作经验的时间段不能重叠
        durationShouldNotOverlap(startDate, endDate);

        WorkExperience newExperience = new WorkExperience(
                tenantId
                , startDate
                , endDate
                , LocalDateTime.now()
                , userId);
        newExperience.setCompany(company);
        experiences.add(newExperience);
    }

    private void skillTypeShouldNotDuplicated(Long newSkillTypeId) throws BusinessException {
        if (skills.stream().anyMatch(
                s -> s.getSkillTypeId() == newSkillTypeId)) {
            throw new BusinessException("同一技能不能录入两次！");
        }
    }

    // 实现业务规则
    private void onlyProbationCanBecomeRegular() throws BusinessException {
        if (status != PROBATION) {
            throw new BusinessException("试用期员工才能转正！");
        }
    }

    private void shouldNotTerminateAgain() throws BusinessException {
        if (status == TERMINATED) {
            throw new BusinessException("已经终止的员工不能再次终止！");
        }
    }

    private void durationShouldNotOverlap(LocalDate startDate
            , LocalDate endDate) throws BusinessException {
        if (experiences.stream().anyMatch(
                e -> overlap(e, startDate, endDate))) {
            throw new BusinessException("工作经验的时间段不能重叠!");
        }
    }

    private boolean overlap(WorkExperience experience
            , LocalDate otherStart, LocalDate otherEnd) {
        LocalDate thisStart = experience.getStartDate();
        LocalDate thisEnd = experience.getEndDate();
        return otherStart.isBefore(thisEnd) && otherEnd.isAfter(thisStart);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setGender(com.hf.left.domain.orgmng.emp.Gender gender) {
        Gender = gender;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
