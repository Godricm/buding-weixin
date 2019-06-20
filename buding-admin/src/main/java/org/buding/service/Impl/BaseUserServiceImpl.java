package org.buding.service.Impl;

import com.github.pagehelper.PageHelper;
import org.buding.common.api.UUIDUtils;
import org.buding.dao.BaseUserMapper;
import org.buding.domain.BaseUser;
import org.buding.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@Service
public class BaseUserServiceImpl implements BaseUserService {
    //private final Logger logger=LoggerFactory.getLogger(this.getClass());

    private static final String SLAT="buding";

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int insert(BaseUser user) {
        //查找用户是否存在
        BaseUser baseUser=baseUserMapper.loadByLoginName(user.getLoginName());
        if(baseUser!=null){
            return -1;
        }
        //设置Id
        user.setId(UUIDUtils.createUUID());
        //设置slat
        user.setSlat(SLAT);
        //密码加密
        String password=passwordEncoder.encode(user.getPassword()+user.getSlat());
        user.setPassword(password);
        //创建时间
        user.setCreatedTime(new Date());
       return baseUserMapper.insert(user);
    }

    @Override
    public int delete(String id) {
        return baseUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(BaseUser user) {
       return baseUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public BaseUser load(String id) {
       return baseUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BaseUser> pageList(BaseUser user, int offset, int pagesize) {
        PageHelper.startPage(offset, pagesize);
        Weekend<BaseUser> example = Weekend.of(BaseUser.class);
        WeekendCriteria<BaseUser, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(user.getNickName())) {
            criteria.andLike(BaseUser::getNickName, "%" +user.getNickName() + "%");
        }
        List<BaseUser> list = baseUserMapper.selectByExample(example);
        return list;
    }
}
