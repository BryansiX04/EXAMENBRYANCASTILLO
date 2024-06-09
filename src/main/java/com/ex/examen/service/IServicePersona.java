package com.ex.examen.service;


import com.ex.examen.model.Persona;

import java.util.List;

public interface IServicePersona {

    List<Persona> Get();
    Persona FindPersonaById(Integer id);
    //guardar
    Persona Save(Persona entity);
    //actualizar
    Integer update(Integer id, Persona persona);
    //elinar
    Integer delete(Integer cod);


}
