package com.yuda.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuda.usercenter.model.User;

public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);
}
