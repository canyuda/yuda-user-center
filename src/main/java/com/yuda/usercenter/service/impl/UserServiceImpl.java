package com.yuda.usercenter.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuda.usercenter.mapper.UserMapper;
import com.yuda.usercenter.model.User;
import com.yuda.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public static final String YUDA_SALT = "YUDA";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        if (Pattern.matches("\\\\\\*\\w+\\*/", userAccount)) {
            return -1;
        }
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userAccount);
        long count = this.count(queryWrapper);
        if (count > 0) {
            return -1;
        }
        // 2. 加密
        String encodePassword = SecureUtil.md5(YUDA_SALT + userPassword);
        User entity = new User();
        entity.setUserName("默认名称");
        entity.setUserAccount(userAccount);
        entity.setUserPassword(encodePassword);
        boolean saveResult = this.save(entity);
        if (!saveResult) {
            return -1;
        }
        return 0;
    }
}
