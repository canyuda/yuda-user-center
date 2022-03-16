package com.yuda.usercenter.mapper;

import com.yuda.usercenter.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void insertTest() {
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
        entity.setIsDeleted(false);
        int insert = userMapper.insert(entity);
        Assertions.assertEquals(1, insert);

    }
}