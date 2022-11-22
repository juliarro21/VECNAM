package com.apuestas.Apuestas.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apuestas.Apuestas.model.Purse;
import com.apuestas.Apuestas.model.User;
import com.apuestas.Apuestas.service.CardsService;
import com.apuestas.Apuestas.service.PurseService;
import com.apuestas.Apuestas.service.UserService;



@Controller
public class UserController {
 @Autowired
 private PurseService purseService;
 @Autowired
 private UserService userService;
 @Autowired
 private CardsService cardsService;
 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  model.setViewName("user/login");
  return model;
 }
 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  model.setViewName("user/signup");
  
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findByUsuario(user.getUsuario());
  
  if(userExists != null) {
   System.out.println("El usuario ya existe");

   bindingResult.rejectValue("usuario", "error.user", "El usuario ya existe");
  }
  if(bindingResult.hasErrors()) {
   System.out.println(bindingResult.getAllErrors());

   model.setViewName("user/signup");
  } else {
   System.out.println("Hola");

   userService.saveUser(user);
   model.addObject("msg", "¡Usuario registrado con exito!");
   model.addObject("user", new User());
   model.setViewName("user/signup");
  }
  
  return model;
 }
 @RequestMapping(value={"/monedero"}, method=RequestMethod.GET)
    public ModelAndView monedero() {
    ModelAndView model = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    
    model.addObject("cards", cardsService.findByUser(userService.findByUsuario(auth.getName()).getId()));
    model.addObject("monedero", purseService.findByUser(auth.getName()));
    model.addObject("userName", "Bienvenido " + auth.getName());
    model.setViewName("user/purse");
    return model;
    }
 @RequestMapping(value={"/pago"}, method=RequestMethod.POST)
   public ModelAndView pago(@Valid Purse purse, BindingResult bindingResult) {
      ModelAndView model = new ModelAndView();
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      purseService.create(purse, auth.getName());
      model.addObject("monedero", purseService.findByUser(auth.getName()));
      model.addObject("userName", "Bienvenido " + auth.getName());
      model.setViewName("user/purse");
      return model;
   }
 
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }

 
}