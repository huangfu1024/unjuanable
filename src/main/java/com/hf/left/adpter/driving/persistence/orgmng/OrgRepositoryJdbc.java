package com.hf.left.adpter.driving.persistence.orgmng;

import com.hf.left.domain.orgmng.org.Org;
import com.hf.left.domain.orgmng.org.OrgRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/5 11:45
 * @version: 1.0
 */
@Component
public class OrgRepositoryJdbc implements OrgRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrgRepositoryJdbc.class);

    @Override
    public Org save(Org org) {
        org.setId(111L);
        logger.info("save org:{}", org);
        return org;
    }
}
