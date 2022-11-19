package com.apuestas.Apuestas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Purse;
import com.apuestas.Apuestas.model.User;
import com.apuestas.Apuestas.repository.PurseRepository;
import com.apuestas.Apuestas.repository.UserRepository;
@Service("purseService")
public class PurseServiceImpl implements PurseService {
    @Autowired
    private PurseRepository purseRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Purse findByUser(String user) {
        User user1 = userRepository.findByUsuario(user);
        return purseRepository.findByUser(user1.getId());
    }
    @Override
    public void create(Purse purse, String user) {
        if(this.findByUser(user)!=null) {
            Purse purse1 = this.findByUser(user);
            purse1.setSaldo(purse1.getSaldo()+purse.getSaldo());
            purseRepository.save(purse1);
        }else{
            User user1 = userRepository.findByUsuario(user);
            purse.setUsers(user1);
            purseRepository.save(purse);
        }
        purseRepository.save(purse);
    }
}
