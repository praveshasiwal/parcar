package com.hcl.parkar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkar.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	

	

}

//package com.hcl.parkar.dao;
//import java.util.List;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//
//
//import com.hcl.parkar.model.UserEntity;
//
//
//
//
//
//@Repository
//public interface UserRepository extends CrudRepository<UserEntity, Long> {
//List<UserEntity> findbyid(String UserName);
//
//
//}