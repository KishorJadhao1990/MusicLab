package com.eao.musiclab.service;

import com.eao.musiclab.bo.UserBO;

import java.util.List;

public interface UserService {

    void save(UserBO userBO);

    UserBO editUser(String id, UserBO userBO);

    void deleteUser(String id);

    UserBO getUser(String id);

    List<UserBO> getUsers();
}
