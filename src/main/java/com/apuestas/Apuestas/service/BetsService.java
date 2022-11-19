package com.apuestas.Apuestas.service;

import java.util.List;

import com.apuestas.Apuestas.model.Bets;

public interface BetsService {
    public void create(Bets bet);
    public List<Bets> findAll();
}
