package com.hf.left.domain.orgmng.emp;

import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:51
 * @version: 1.0
 */
@Component
public interface EmpRepository {

    public void save(Emp emp);
}
