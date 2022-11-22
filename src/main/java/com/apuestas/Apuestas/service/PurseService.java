package com.apuestas.Apuestas.service;

import com.apuestas.Apuestas.model.Purse;

public interface PurseService {
    public Purse findByUser(String user);
    public void create(Purse purse, String user);
    public void updateSaldo(float total, String user);
}
