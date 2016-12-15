package com.huan.service.impl;

import com.huan.bean.UserInfoBean;
import com.huan.mapper.UserInfoMapper;
import com.huan.model.UserInfo;
import com.huan.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanhuanhuan
 */
@Service
public class MainPageServiceImpl implements MainPageService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Cacheable(value = "usercache", key = "'userId_' + #id")
    public UserInfo selectUserDetail(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @CachePut(value = "usercache", key = "'userId_' + #param.id")
    public void updateUser(UserInfoBean param) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(param.getId());
        userInfo.setEmail(param.getEmail());
        userInfo.setNetName(param.getJob());
        userInfo.setMobile(param.getMobile());
        userInfo.setUsername(param.getUsername());
        userInfo.setFamilyNativePlace(param.getFamilyNativePlace());
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @CachePut(value = "usercache", key = "'userId_' + #param.id")
    public void add(UserInfoBean param) {
        System.out.println("UserService: method- add(UserInfoBean param)");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(param.getId());
        userInfo.setEmail(param.getEmail());
        userInfo.setNetName(param.getJob());
        userInfo.setMobile(param.getMobile());
        userInfo.setUsername(param.getUsername());
        userInfo.setFamilyNativePlace(param.getFamilyNativePlace());
        userInfoMapper.insert(userInfo);
    }

}
