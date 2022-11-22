package com.apuestas.Apuestas.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.apuestas.Apuestas.model.Cards;
import com.apuestas.Apuestas.service.CardsService;
import com.apuestas.Apuestas.service.UserService;

@Controller
public class CardController {
    @Autowired
    private UserService userService;
    @Autowired
    private CardsService cardsService;
    @RequestMapping(value = "/pagos_tajeta", method = RequestMethod.GET)
    public ModelAndView paid() {
        ModelAndView model = new ModelAndView();
        model.addObject("mensage","");
        model.setViewName("user/card");
        return model;
    }
    @RequestMapping(value= {"/registrar_tarjeta"}, method=RequestMethod.POST)
    public ModelAndView registrarTarjeta(@Valid Cards cards, BindingResult bindingResult) {
     ModelAndView model = new ModelAndView();
     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     cards.setUsers(userService.findByUsuario(auth.getName()));
     cardsService.create(cards);
     model.addObject("mensage"," Tarjeta registrada con exito");
     model.setViewName("user/card");
     return model;
    }
   
}
