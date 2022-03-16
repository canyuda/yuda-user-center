package com.yuda.usercenter.service;

import com.yuda.usercenter.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testDeleted() {
        boolean result = userService.removeById(userService.list().get(0).getId());
        Assertions.assertTrue(result);
    }

    @Test
    public void testInsert() {
        User entity = new User();
        entity.setUserName("");
        entity.setUserAccount("");
        entity.setAvatarUrl("");
        entity.setGender(0);
        entity.setUserPassword("");
        entity.setPhone("");
        entity.setEmail("");
        entity.setUserStatus(0);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        boolean save = userService.save(entity);
        Assertions.assertTrue(save);
    }

    @Test
    void userRegister() {
        long result = userService.userRegister("canyuda", "", "12345678");
        Assertions.assertEquals(-1, result);
        long result2 = userService.userRegister("canyuda4", "123456789", "123456789");
        Assertions.assertNotEquals(-1, result2);
    }
}