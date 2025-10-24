package com.eao.musiclab.service.impl;

import com.eao.musiclab.bo.UserBO;
import com.eao.musiclab.framework.BizException;
import com.eao.musiclab.model.User;
import com.eao.musiclab.repository.UserRepository;
import com.eao.musiclab.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserBO userBO) {
        if (StringUtils.isEmpty(userBO.getUsername())
                || StringUtils.isEmpty(userBO.getEmail())
                || Objects.isNull(userBO.getMobileNo())){
            throw new BizException("Username, Email and MobileNo can't be empty.");
        }
        userRepository.save(UserBO.from(userBO));
    }

    @Override
    public UserBO editUser(String id, UserBO userBO) {
        Optional<User> userOpt = userRepository.findById(Integer.parseInt(id));
        if (userOpt.isEmpty()) {
            throw new BizException("User not found");
        }
        User user = userOpt.get();
        user.setEmail(userBO.getEmail());
        user.setUsername(userBO.getUsername());
        user.setFirstname(userBO.getFirstname());
        user.setLastname(userBO.getLastname());
        user.setMobileNo(userBO.getMobileNo());
        userRepository.save(user);
        return UserBO.from(user);
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> userOpt = userRepository.findById(Integer.parseInt(id));
        if (userOpt.isEmpty()) {
            throw new BizException("User not found");
        }
        userRepository.delete(userOpt.get());
    }

    @Override
    public UserBO getUser(String id) {
        Optional<User> userOpt = userRepository.findById(Integer.parseInt(id));
        if (userOpt.isEmpty()) {
            throw new BizException("User not found");
        }
        return UserBO.from(userOpt.get());
    }

    @Override
    public List<UserBO> getUsers() {
        return userRepository.findAll().stream().map(UserBO::from).toList();
    }
}
