package com.hf.left.application.orgmng;

import com.hf.left.common.util.Gender;
import com.hf.left.domain.orgmng.emp.Emp;
import com.hf.left.domain.orgmng.emp.EmpHandler;
import com.hf.left.domain.orgmng.org.OrgValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/11 14:28
 * @version: 1.0
 */
@Component
public class EmpAssembler {

    EmpHandler handler;
    // Emp的领域服务
    OrgValidator orgValidator;

    @Autowired
    public EmpAssembler(EmpHandler handler, OrgValidator orgValidator) {
        this.handler = handler;
        this.orgValidator = orgValidator;
    }

    // 由 DTO 生成领域对象
    Emp fromCreateRequest(CreateEmpRequest request, User user) {
        //校验参数
        validateCreateRequest(request);

        // 生成员工号
        String empNum = handler.generateNum();

        Emp result = new Emp(request.getTenantId(), LocalDateTime.now(), user.getId());
        result.setNum(empNum);
        result.setIdNum(request.getIdNum());
        result.setDob(request.getDob());
        result.setOrgId(request.getOrgId());
        result.setGender(Gender.ofCode(request.getGenderCode()));

//        request.getSkills().forEach(s -> result.addSkill(
//                s.getSkillTypeId(), SkillLevel.ofCode(s.getLevelCode())
//                , s.getDuration()
//                , user.getId()));
//
//        request.getExperiences().forEach(e -> result.addExperience(
//                e.getStartDate()
//                , e.getEndDate()
//                , e.getCompany()
//                , user.getId()));

        return result;
    }

    void validateCreateRequest(CreateEmpRequest request) {
        //业务规则：组织应该有效
        orgValidator.orgShouldValid(request.getTenantId(), request.getOrgId());
    }

    // 将领域对象转换成 DTO
    EmpResponse toResponse(Emp emp) {
       return new EmpResponse();
    }
}
