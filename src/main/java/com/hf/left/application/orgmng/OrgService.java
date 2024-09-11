package com.hf.left.application.orgmng;

import com.hf.left.domain.orgmng.org.OrgBuilder;
import com.hf.left.domain.orgmng.org.OrgBuilderFactory;
import com.hf.left.domain.orgmng.org.OrgRepository;
import com.hf.left.domain.orgmng.org.Org;
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

    public OrgResponse addOrg(OrgResponse request, Long userId){
        OrgBuilder orgBuilder = orgBuilderFactory.create();
        Org org = orgBuilder.tenantId(request.getTenantId()).build();
        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private OrgResponse buildOrgDto(Org org) {
        // 将领域对象的值赋给DTO
        return null;
    }

    private Org buildOrg(OrgResponse request, Long userId) {
        // 将DTO的值赋给领域对象...
        return null;
    }
}
