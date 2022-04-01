package com.hcl.parkar.service;

import java.util.List;
import java.util.Optional;

import com.hcl.parkar.model.UserEntity;

public interface UserService {

	public UserEntity getUserEntity(Long id);

	public List<UserEntity> list();

	public UserEntity save(UserEntity userEntity);

	public UserEntity update(String username, UserEntity userEntity);

	public Boolean delete(Long id);
	
	public UserEntity getByUserNameAndPassword(String username , String password);

}