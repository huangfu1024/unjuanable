package com.hf.left.adpter.driven.restful.orgmng;

import com.hf.left.application.orgmng.OrgResponse;
import com.hf.left.application.orgmng.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/4 14:52
 * @version: 1.0
 */
@RestController
public class OrgController {

    private OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService){
        this.orgService = orgService;
    }

    @PostMapping("/api/organizations")
    public OrgResponse addOrg(@RequestBody OrgResponse orgDto){
        return orgService.addOrg(orgDto, 1L);
    }
}
