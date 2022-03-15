package com.hcl.parkar.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkar.model.UserEntity;



@Repository
	public interface UserRepository extends CrudRepository<UserEntity, Long> {
	  List<UserEntity> findbyUserName(String x);
	  
		
			
		    public void customMethod();
		}

