package com.apuestas.Apuestas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestas.Apuestas.model.Bets;
@Repository("betsRepository")


public interface BetsRepository extends JpaRepository<Bets, Integer> {
    Bets findById(int id);
    
}
