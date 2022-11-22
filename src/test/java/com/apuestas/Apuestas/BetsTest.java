package com.apuestas.Apuestas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.apuestas.Apuestas.model.Bets;
import com.apuestas.Apuestas.repository.BetsRepository;
import com.apuestas.Apuestas.repository.EventEquiposRepository;
import com.apuestas.Apuestas.repository.UserRepository;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class BetsTest {
    @Autowired
    private BetsRepository betsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventEquiposRepository eventEquiposRepository;
    @Test
    @Rollback(false)
    public void createBets() {
        Bets bet = new Bets();
        bet.setCantidad(100);
        bet.setEventos_equipos(eventEquiposRepository.getReferenceById(1));
        bet.setUsers(userRepository.findByUsuario("user"));
        Bets betSave=betsRepository.save(bet);
        assert betSave!=null;
    }
}
