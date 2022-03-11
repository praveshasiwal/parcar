package com.hcl.parkar.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hcl.parkar.model.UserEntity;
import com.hcl.parkar.service.UserService;
@Controller
@RequestMapping("/v1/api/User")
public class UserController {
@Autowired
private UserService userService;
@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
UserEntity userResult = userService.save(user);
ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(userResult, HttpStatus.CREATED);
return responseEntity;
}
@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
public ResponseEntity<UserEntity> get(@PathVariable int id) {
UserEntity userResult = ((List<UserEntity>) userService).get(id);
ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(userResult, HttpStatus.OK);
return responseEntity;
}
@RequestMapping(value = "/{}", method = RequestMethod.POST, consumes = "application/user", produces = "application/user")
public ResponseEntity<UserEntity> update(@PathVariable String Password, @RequestBody UserEntity user) {
UserEntity userResult = userService.save(user);
ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(HttpStatus.OK);
return responseEntity;
}
@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/user", produces = "application/user")
public ResponseEntity<Boolean> delete(@PathVariable Long id) {
Boolean userResult = userService.delete(id);
ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(userResult, HttpStatus.OK);
return responseEntity;
}
@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/user", produces = "application/user")
public ResponseEntity<List<UserEntity>> list() {
List<UserEntity> userResult = userService.list();
ResponseEntity<List<UserEntity>> responseEntity = new ResponseEntity<>(userResult, HttpStatus.OK);
return responseEntity;
}
}