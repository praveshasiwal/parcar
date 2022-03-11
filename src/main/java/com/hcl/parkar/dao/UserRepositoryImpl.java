package com.hcl.parkar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.hcl.parkar.dao.UserRepository.UserRepositoryCustom;


public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    @Lazy
    UserRepository userRepository;  /* Optional - if you need it */

    public void customMethod() {  }
}
