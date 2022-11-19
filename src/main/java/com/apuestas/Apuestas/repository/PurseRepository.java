package com.apuestas.Apuestas.repository;

import org.springframework.stereotype.Repository;

import com.apuestas.Apuestas.model.Purse;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository("purseRepository")
public interface PurseRepository extends JpaRepository<Purse, Integer> {
    @Query(value = "SELECT * FROM Purse  WHERE Purse.id_user = ?", nativeQuery = true)
    Purse findByUser(int i);

}
    

