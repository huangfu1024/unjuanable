package com.hf.left.application.orgmng;

import com.hf.left.domain.orgmng.emp.Emp;
import com.hf.left.domain.orgmng.emp.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:51
 * @version: 1.0
 */
@Service
public class EmpService {

    private final EmpRepository empRepository;

    private final EmpAssembler empAssembler;

    @Autowired
    public EmpService(EmpRepository empRepository, EmpAssembler empAssembler) {
        this.empRepository = empRepository;
        this.empAssembler = empAssembler;
    }

    public EmpResponse addEmp(CreateEmpRequest request, User user){
        Emp emp = empAssembler.fromCreateRequest(request, user);
        empRepository.save(emp);
        return empAssembler.toResponse(emp);
    }
}
