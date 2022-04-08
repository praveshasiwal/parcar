package com.hcl.parkar.service.impl;

import com.hcl.parkar.constant.ParkarConstant;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkar.dao.UserRepository;
import com.hcl.parkar.exception.NoDataFoundException;
import com.hcl.parkar.exception.ParKarException;
import com.hcl.parkar.model.UserEntity;
import com.hcl.parkar.service.UserService;
import com.hcl.parkar.util.PasswordUtility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
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
	@Transactional
	public List<UserEntity> list() {

		List<UserEntity> userEntity = (List<UserEntity>) userRepository.findAll();
		if (userEntity.isEmpty()) {
			throw new NoDataFoundException();
		}
		return userEntity;
	}

	@Override
	@Transactional
	public UserEntity save(UserEntity userEntity) {
		userEntity.setUserName(String.valueOf(userEntity.getMobileNumber()));
		userEntity.setPassword(PasswordUtility.toHexString(userEntity.getPassword()));
		return userRepository.save(userEntity);
	}

	@Override
	@Transactional
	public UserEntity update(String userName, UserEntity initialUserEntity) {
		if (initialUserEntity.getUserName() != null) {
			Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userName);
			if (optionalUserEntity.isPresent()) {
				UserEntity userEntity = optionalUserEntity.get();
				userEntity.setFirstName(initialUserEntity.getFirstName());
				userEntity.setLastName(initialUserEntity.getLastName());
				userEntity.setEmail(initialUserEntity.getEmail());
				userEntity.setPassword(initialUserEntity.getPassword());
				userEntity.setLicenseId(initialUserEntity.getLicenseId());
				userEntity.setMobileNumber(initialUserEntity.getMobileNumber());
				return userRepository.save(userEntity);
			}
		}
		return null;
	}

	@Override
	@Transactional
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

	@Override
	public UserEntity getByUserNameAndPassword(String username, String password) {
		Optional<UserEntity> optionalEntity = userRepository.findByUserName(username);
		if (optionalEntity.isPresent()) {
			UserEntity userEntity = optionalEntity.get();
			String encodedPassword = PasswordUtility.toHexString(password);
			if (userEntity.getPassword().equals(encodedPassword)) {
				userEntity.setPassword(null);
				return userEntity;
			}
		}
		throw new ParKarException(ParkarConstant.userNotFound);
	}

}
