package com.ex.examen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private   int  id;
      private  String nombre ;
      private  String apeMaterno;
      private  String apePaterno;
      private  int  edad ;
}
