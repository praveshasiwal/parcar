package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkar.dao.UserRepository;
import com.hcl.parkar.model.UserEntity;
import com.hcl.parkar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity getUserEntity(Long id) {

		if (null != id) {
			Optional<UserEntity> userEntity = userRepository.findById(id);
			if (userEntity.isPresent()) {
				return userEntity.get();
			}
		}
		return null;

	}

	@Override
	public List<UserEntity> list() {

		return userRepository.findAll();
	}

	@Override
	public UserEntity save(UserEntity userEntity) {

		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity update(String username, UserEntity userEntity) {
        if (userEntity.getusername() != null) {
        	Optional<UserEntity> optional = userRepository.findByUserName(username);
        	if (optional.isPresent()) {
        		UserEntity intermidiate = optional.get();
      			intermidiate.setFirstName(userEntity.getFirstName());
    			intermidiate.setLastName(userEntity.getLastName());
      			intermidiate.setEmail(userEntity.getEmail());
      			intermidiate.setPassword(userEntity.getPassword());
     			return userRepository.save(intermidiate);
    		}
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		if (null != id) {
			Optional<UserEntity> userEntity = userRepository.findById(id);

			if (userEntity.isPresent()) {
				userRepository.deleteById(id);
				return true;
			}
		}
		return false;

	}


}
