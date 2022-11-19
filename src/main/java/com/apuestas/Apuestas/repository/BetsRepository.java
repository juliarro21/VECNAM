package com.apuestas.Apuestas.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apuestas.Apuestas.model.Bets;

public interface BetsRepository extends JpaRepository<Bets, Integer> {
    Bets findById(int id);
    
}
