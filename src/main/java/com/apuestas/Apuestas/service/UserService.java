package com.apuestas.Apuestas.service;

import com.apuestas.Apuestas.model.User;

public interface UserService {
  
 public User findByUsuario(String usuario);
 public void saveUser(User user);
 
}