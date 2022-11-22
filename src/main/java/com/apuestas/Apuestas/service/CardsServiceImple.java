package com.apuestas.Apuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Cards;
import com.apuestas.Apuestas.repository.CardRepository;

@Service("cardsService")
public class CardsServiceImple  implements CardsService{
    @Autowired
    private CardRepository cardRepository;
    @Override
    public void create(Cards card) {
        cardRepository.save(card);
    }
    
    public List<Cards> findByUser(int idUser) {
        return cardRepository.findByUser(idUser);
    }
}
