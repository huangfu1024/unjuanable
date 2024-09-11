package com.hf.left.domain.orgmng.emp;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/6 09:48
 * @version: 1.0
 */
public enum EmpStatus {

    REGULAR("REG"), PROBATION("PRO"), TERMINATED("TER");

    private final String name;

    EmpStatus(String name){
        this.name = name;
    }
}
