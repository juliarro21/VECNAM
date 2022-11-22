package com.apuestas.Apuestas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.apuestas.Apuestas.model.GeneroTipo;
import com.apuestas.Apuestas.model.User;
import com.apuestas.Apuestas.repository.UserRepository;

/* Test de usuarios*/
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @Rollback(false)
    //Prueba de guardar usuario
    public void createUser() {
        //Creamos un usuario
        User user = new User();
        user.setNombre("Juan");
        user.setCedula(123456789);
        user.setFecha_nacimiento("01-01-2000");
        user.setGenero(GeneroTipo.MASCULINO);
        user.setDireccion("Calle 1");
        user.setUsuario("juan");
        user.setContrasena("1234");
        //Guarda el usuario
        User userSave=userRepository.save(user);
        //Comprueba que el usuario se guardo
        assert userSave!=null;
    }

    @Test
    //Prueba de buscar usuario
    public void findByUsuario() {
        //Busca el usuario
        User user = userRepository.findByUsuario("user");
        //Comprueba que el usuario se encontro
        assertEquals(user.getUsuario(), "user");
    }

}
