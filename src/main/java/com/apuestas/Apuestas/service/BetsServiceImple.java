package com.apuestas.Apuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Bets;
import com.apuestas.Apuestas.repository.BetsRepository;


@Service("betsService")
public class BetsServiceImple implements BetsService {
    @Autowired
    private BetsRepository betsRepository;
    
        @Override
        public void create(Bets bet) {
            betsRepository.save(bet);
        }

        @Override
        public List<Bets> findAll() {
            // TODO Auto-generated method stub
            return null;
        }

        /* public List<Bets> findByIdEventos(int idEventos) {
            return betsRepository.findByIdEventos(idEventos);
        } */
        
    }
