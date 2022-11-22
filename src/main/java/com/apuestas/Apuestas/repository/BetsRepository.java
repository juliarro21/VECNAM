package com.apuestas.Apuestas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.apuestas.Apuestas.model.Bets;

@Repository("betsRepository")

public interface BetsRepository extends JpaRepository<Bets, Integer> {
    Bets findById(int id);
    @Query(value ="SELECT * FROM apuestas WHERE apuestas.id_user = ? ", nativeQuery = true)
    List<Bets> findByUser(int iduser);
}
