package org.buding.dao;

import org.buding.domain.BaseUser;
import org.buding.util.BaseMapper;

public interface BaseUserMapper extends BaseMapper<BaseUser> {
    BaseUser loadByLoginName(String loginName);
}