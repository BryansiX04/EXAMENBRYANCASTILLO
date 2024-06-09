package com.ex.examen.controller;


import com.ex.examen.model.Persona;
import com.ex.examen.service.IServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    /*
     * Consultar => GET
     * Grabar => POST
     * Actualizar => PUT(*) / PATCH
     * Eliminar => DELETE
     * */
    IServicePersona iServicePersona;

    @Autowired
    public PersonaController(IServicePersona iServicePersona) {
        this.iServicePersona=iServicePersona;
    }

    //listar  animal
    @GetMapping("/listar")
    public List<Persona> getAll() {return iServicePersona.Get();}

    @PostMapping("/guardar")
    public Persona save(@RequestBody Persona entity) {
        return iServicePersona.Save(entity);
    }


    @GetMapping("/buscar/{id}")
    public Persona getAll(@PathVariable int id) {
        return iServicePersona.FindPersonaById(id);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody Persona persona) {
        Integer updated = iServicePersona.update(id, persona);
        if (updated == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        Integer deleted = iServicePersona.delete(id);
        if (deleted == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
