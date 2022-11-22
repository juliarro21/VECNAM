package com.apuestas.Apuestas.service;

import java.util.List;

import com.apuestas.Apuestas.model.Cards;

public interface CardsService {
    public void create(Cards card);
    public List<Cards> findByUser(int idUser);
}
