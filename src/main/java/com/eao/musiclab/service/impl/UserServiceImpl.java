package com.eao.musiclab.service.impl;

import com.eao.musiclab.bo.UserBO;
import com.eao.musiclab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void save(UserBO userBO) {

    }

    @Override
    public UserBO editUser(String id, UserBO userBO) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public UserBO getUser(String id) {
        return null;
    }

    @Override
    public List<UserBO> getUsers() {
        return List.of();
    }
}
