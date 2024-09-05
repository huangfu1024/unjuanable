package com.hf.left.application.orgmng;

import com.hf.left.domain.orgmng.OrgBuilder;
import com.hf.left.domain.orgmng.OrgBuilderFactory;
import com.hf.left.domain.orgmng.OrgRepository;
import com.hf.left.domain.orgmng.Org;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:52
 * @version: 1.0
 */
@Service
public class OrgService {

    private final OrgRepository orgRepository;

    private final OrgBuilderFactory orgBuilderFactory;

    public OrgService(OrgRepository orgRepository, OrgBuilderFactory orgBuilderFactory){
        this.orgRepository = orgRepository;
        this.orgBuilderFactory = orgBuilderFactory;
    }

    public OrgDto addOrg(OrgDto request, Long userId){
        OrgBuilder orgBuilder = orgBuilderFactory.create();
        Org org = orgBuilder.tenantId(request.getTenantId()).build();
        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private OrgDto buildOrgDto(Org org) {
        // 将领域对象的值赋给DTO
        return null;
    }

    private Org buildOrg(OrgDto request, Long userId) {
        // 将DTO的值赋给领域对象...
        return null;
    }



}
