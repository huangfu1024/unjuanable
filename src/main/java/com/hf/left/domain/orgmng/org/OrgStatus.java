package com.hf.left.domain.orgmng.org;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/5 11:22
 * @version: 1.0
 */
public enum OrgStatus {

    EFFECTIVE("effective"),    CANCEL("cancel");


    private String name;

    OrgStatus(String name) {
        this.name = name;
    }

}
