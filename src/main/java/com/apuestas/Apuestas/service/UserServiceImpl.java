package com.apuestas.Apuestas.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Role;
import com.apuestas.Apuestas.model.User;
import com.apuestas.Apuestas.repository.RoleRepository;
import com.apuestas.Apuestas.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private RoleRepository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findByUsuario(String usuario) {
  return userRepository.findByUsuario(usuario);
 }
 @Override
 public void saveUser(User user) {
  user.setContrasena(bCryptPasswordEncoder.encode(user.getContrasena()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("USER");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }
}