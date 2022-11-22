package com.apuestas.Apuestas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apuestas.Apuestas.model.Cards;

@Repository("cardRepository")
public interface CardRepository extends JpaRepository<Cards, Integer> {
    @Query(value = "SELECT * FROM tarjetas  WHERE tarjetas.id_user = ?", nativeQuery = true)
    List<Cards> findByUser(int idUser);
}
