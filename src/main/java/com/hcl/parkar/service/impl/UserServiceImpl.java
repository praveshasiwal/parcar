package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



import com.hcl.parkar.dao.UserRepository;
import com.hcl.parkar.model.UserEntity;
import com.hcl.parkar.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	CrudRepository userRepository;
	
	@Override
	public UserEntity getUserEntity(Long id) {
		// TODO Auto-generated method stub
		if(null != id)
			 return ((JpaRepository<UserEntity, Long>) userRepository).getOne(id);
        return null;
	}

	@Override
	public List<UserEntity> list() {
		// TODO Auto-generated method stub
		return (List<UserEntity>) userRepository.findAll();
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return (UserEntity) userRepository.save(userEntity);
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		// TODO Auto-generated method stub
		if(userEntity.getId() !=0) {
			return (UserEntity) userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		if(null != id) {
			Optional<UserEntity> userEntity = userRepository.findById(id);
			
			if(userEntity.isPresent()) {
				userRepository.deleteById(id);
				return true;
			}
		}				
		return false;
	
	}
	
	
	

}
