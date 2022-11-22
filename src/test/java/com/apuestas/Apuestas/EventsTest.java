package com.apuestas.Apuestas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.apuestas.Apuestas.model.Event;
import com.apuestas.Apuestas.repository.EventRepository;

/* Test de eventos*/
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventsTest {
    @Autowired
    private EventRepository eventRepository;

    //Prueba de guardar evento
    @Test
    //No borra la base de datos
    @Rollback(false)
    public void createEvent() {
        //Creamos un evento
        Event event = new Event();
        event.setNombre("Partido de futbol");
        event.setEquipo1(1);
        event.setEquipo2(2);
        event.setFecha("01-01-2020");
        event.setHora("12:00");
        event.setEquipo1(1);
        event.setEquipo2(2);
        //Guarda el evento
        Event eventSave=eventRepository.save(event);
        //Comprueba que el evento se guardo
        assert eventSave!=null;
    }
    @Test
    //Prueba de buscar evento
    public void findByName() {
        //Busca el evento
        Event event = eventRepository.findByNombre("Partido de futbol");
        //Comprueba que el evento se encontro
        assertEquals(event.getNombre(), "Partido de futbol");
    }
    @Test
    //Prueba listar eventos
    public void listEvents() {
        //Lista los eventos
        Iterable<Event> events = eventRepository.findAll();
        //Comprueba que la lista no esta vacia
        assert events.iterator().hasNext();
    }
    @Test
    //Prueba de buscar evento por id
    public void findById() {
        //Busca el evento
        Event event = eventRepository.findById(1);
        //Comprueba que el evento se encontro
        assertEquals(event.getId(), 1);
    }
    @Test
    //Prueba de editar por evento
    public void editEvent() {
        //Busca el evento
        Event event = eventRepository.findById(1);
        //Edita el evento
        event.setNombre("Partido de futbol editado");
        //Guarda el evento
        Event eventSave=eventRepository.save(event);
        //Comprueba que el evento se guardo
        assert eventSave!=null;
    }
}
