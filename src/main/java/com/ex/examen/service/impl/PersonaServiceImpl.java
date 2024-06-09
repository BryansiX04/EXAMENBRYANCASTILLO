package com.ex.examen.service.impl;



import com.ex.examen.model.Persona;
import com.ex.examen.repository.PersonaRepository;
import com.ex.examen.service.IServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl   implements IServicePersona {


    PersonaRepository _personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        _personaRepository = personaRepository;
    }



    @Override
    public List<Persona> Get() {
        return _personaRepository.findAll();
    }

    @Override
    public Persona FindPersonaById(Integer id) {
        Optional<Persona> persona = _personaRepository.findById(id);
        if (persona.isPresent())
            return persona.get();
        else
            return new Persona();
    }

    @Override
    public Persona Save(Persona entity) {
        Persona persona = _personaRepository.save(entity);
        return persona;
    }

    @Override
    public Integer update(Integer id, Persona persona) {

        Optional<Persona> Update = _personaRepository.findById(id);
        if (Update.isPresent()) {
            Persona persona1 = Update.get();

            persona1.setNombre(persona.getNombre());
            persona1.setApeMaterno(persona.getApeMaterno());
            persona1.setApePaterno(persona.getApePaterno());
            persona1.setEdad(persona.getEdad());

            _personaRepository.save(persona1);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer delete(Integer cod) {
        Optional<Persona> optional = _personaRepository.findById(cod);

        if (optional.isPresent()) {
            _personaRepository.deleteById(cod);
            return 1;
        } else {
            return 0;
        }
    }
    }

