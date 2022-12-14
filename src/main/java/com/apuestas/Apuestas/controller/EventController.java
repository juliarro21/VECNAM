package com.apuestas.Apuestas.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apuestas.Apuestas.model.Bets;
import com.apuestas.Apuestas.model.Event;
import com.apuestas.Apuestas.model.EventTeam;
import com.apuestas.Apuestas.model.Team;
import com.apuestas.Apuestas.service.EventTeamService;
import com.apuestas.Apuestas.service.PurseService;
import com.apuestas.Apuestas.service.BetsService;
import com.apuestas.Apuestas.service.EventService;
import com.apuestas.Apuestas.service.TeamService;
import com.apuestas.Apuestas.service.UserService;

@RestController 
@RequestMapping("/eventos")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private EventTeamService eventEquiposService;
    @Autowired
    private BetsService betsService;
    @Autowired
    private UserService userService;
    @Autowired
    private PurseService purseService;
    @RequestMapping(value= {"/listar"}, method=RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("eventos", eventService.findAll());
        model.addObject("teams", teamService.findAll());
        model.setViewName("event/list");
        return model;
    }

     @RequestMapping(value="/crear", method=RequestMethod.POST)
    public ModelAndView crear(@Valid Event event,BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Date fecha = event.getFecha();
      //validacion de fecha y hora
        if(fecha.before(new Date()) || (fecha.equals(new Date()) )) {
            bindingResult.rejectValue("fecha", "error.event", "La fecha debe ser mayor a la actual");
        }
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            eventService.create(event);
            model.addObject("mensage", "Error creando el evento");
            
        } else {
            eventService.create(event);
            model.addObject("mensage", "Evento creado con exito");
        }
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("teams", teamService.findAll());
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("eventos", eventService.findAll());
        model.setViewName("event/list");
        return model;        
    }
    @RequestMapping(value="/ganador", method=RequestMethod.GET)
    public ModelAndView ganador(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        final List<EventTeam> eventTeams =  eventEquiposService.findByIdEventos(id);
        List <Team> teams= new ArrayList<Team>();
         for(EventTeam eventTeam : eventTeams) {
                teams.add(eventTeam.getTeams());
        } 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("teams", teams);
        model.addObject("event", eventService.findById(id));
        model.setViewName("event/winner");
        return model;
    }
    @RequestMapping(value="/apostar", method=RequestMethod.GET)
    public ModelAndView apostar(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        final List<EventTeam> eventTeams =  eventEquiposService.findByIdEventos(id);
        List <Team> teams= new ArrayList<Team>();
         for(EventTeam eventTeam : eventTeams) {
                teams.add(eventTeam.getTeams());
        } 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("mensage", "");
        model.addObject("teams", teams);
        model.addObject("event", eventService.findById(id));
        model.setViewName("event/Bets");
        return model;
    }
    @RequestMapping(value="/apostar", method=RequestMethod.POST)
    public ModelAndView apostar(@RequestParam("id") int id,@ModelAttribute("bets") Bets bets) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mensage="";
        if(purseService.findByUser(auth.getName())==null || purseService.findByUser(auth.getName()).getSaldo()<bets.getCantidad()) {
           mensage="No tiene saldo suficiente";
        }else {
            bets.setEventos_equipos(eventEquiposService.findByIdEventAndIdTeams(id, bets.getTeam()));
            bets.setUsers(userService.findByUsuario(auth.getName()));   
            betsService.create(bets); 
            float total = purseService.findByUser(auth.getName()).getSaldo()-bets.getCantidad();
            
            purseService.updateSaldo(total, auth.getName());
            mensage="Apostado con exito";
        }
        final List<EventTeam> eventTeams =  eventEquiposService.findByIdEventos(id);
        List <Team> teams= new ArrayList<Team>();
         for(EventTeam eventTeam : eventTeams) {
                teams.add(eventTeam.getTeams());
        }
        model.addObject("teams", teams);
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("mensage", mensage);
        model.addObject("event", eventService.findById(id));
        model.setViewName("event/Bets");
        return model;
        
    }
    @RequestMapping(value="/ganador", method=RequestMethod.POST)
    public ModelAndView ganador(@RequestParam("id") int id, @ModelAttribute("event") Event event) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView model = new ModelAndView();
        if(event != null) {
            Event eventDetail = eventService.findById(id);
            eventDetail.setGanador(eventEquiposService.findByIdEventAndIdTeams(id, event.getGanador()).getId());
            eventService.editar(eventDetail);
            model.addObject("mensage", "Ganador asignado con exito");
        }else {
            model.addObject("mensage", "Error asignando el ganador");
        }
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("teams", teamService.findAll());
        model.addObject("role", auth.getAuthorities().toString());
        model.addObject("eventos", eventService.findAll());
        model.setViewName("event/list");
        return model;        
    }
    
}
