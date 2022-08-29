package com.example.usercenter.service.impl;

import com.common.domain.UserCenter;
import com.example.usercenter.dao.UserDao;
import com.example.usercenter.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserServiceImpl implements IUserService {
    private final UserDao userDao;

    @Override
    public UserCenter findById(Integer id) {
        Optional<UserCenter> userCenter = this.userDao.findById(id);
        return userCenter.isPresent() ? userCenter.get() : null;
    }

}
