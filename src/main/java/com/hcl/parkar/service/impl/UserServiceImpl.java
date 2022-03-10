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
	UserRepository userRepository;

	public UserEntity getUserEntity(Long id) {

		if (null != id)
			return userRepository.getOne(id);
		return null;
	}

	public List<UserEntity> list() {
		return userRepository.findAll();
	}

	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	public UserEntity update(UserEntity userEntity) {
		if (userEntity.getId() != 0) {
			return userRepository.save(userEntity);
		}
		return null;
	}

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