package com.deepinto.service.impl;

import com.deepinto.entity.LoginEntity;
import com.deepinto.mapper.DpManagerMapper;
import com.deepinto.pojo.DpManager;
import com.deepinto.pojo.DpManagerExample;
import com.deepinto.service.LoginService;
import com.deepinto.utils.MsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ming
 * @Desc 登录页
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {


    @Autowired
    DpManagerMapper mapper;


    @Override
    public MsResult login(LoginEntity entity) throws Exception {

        DpManagerExample example = new DpManagerExample();

        DpManagerExample.Criteria criteria = example.createCriteria();

        criteria.andMaUnameEqualTo(entity.getUsername());

        criteria.andMaPwdEqualTo(entity.getPassword());

        List<DpManager> dpManagers = mapper.selectByExample(example);


        if (dpManagers.size() > 0) {

            return MsResult.ok(dpManagers);
        } else {

            return MsResult.ok(205, "用户名密码错误");
        }

    }
}
