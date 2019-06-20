package org.buding.service;


import org.buding.domain.BaseUser;
import java.util.List;

public interface BaseUserService {
    /**
     * 新增
     */
     int insert(BaseUser user);

    /**
     * 删除
     */
     int delete(String id);

    /**
     * 更新
     */
    int update(BaseUser user);

    /**
     * 根據主鍵 id 查詢
     */
     BaseUser load(String id);

    /**
     * 分页查询
     */
     List<BaseUser> pageList(BaseUser user, int offset, int pagesize);
}
