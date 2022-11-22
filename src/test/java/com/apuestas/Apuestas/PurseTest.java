package com.apuestas.Apuestas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.apuestas.Apuestas.model.Purse;
import com.apuestas.Apuestas.repository.PurseRepository;
import com.apuestas.Apuestas.repository.UserRepository;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest

public class PurseTest {
    @Autowired
    private PurseRepository purseRepository;
    @Autowired
    private UserRepository userRepository;
    //Prueba de guardar billetera
    @Test
    //No borra la base de datos
    @Rollback(false)
    public void createPurse() {
        //Creamos una billetera
        Purse purse = new Purse();
        purse.setSaldo(100);
        purse.setUsers(userRepository.findByUsuario("user"));
        //Guarda la billetera
        Purse purseSave=purseRepository.save(purse);
        //Comprueba que la billetera se guardo
        assert purseSave!=null;
    }
    @Test
    //Prueba de buscar billetera por usuario
    public void findById() {
        //Busca la billetera
        Purse purse = purseRepository.findByUser(2);
        //Comprueba que la billetera se encontro
        assert purse!=null;
    }
    @Test
    //Prueba de actualizar saldo
    @Rollback(false)
    public void updateSaldo() {
        //Busca la billetera
        Purse purse = purseRepository.findByUser(2);
        //Actualiza el saldo
        purse.setSaldo(200);
        //Guarda la billetera
        Purse purseSave=purseRepository.save(purse);
        //Comprueba que la billetera se guardo
        assert purseSave!=null;
    }
}
