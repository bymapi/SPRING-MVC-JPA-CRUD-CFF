package com.example.SPRINGMVCJPACRUDCFF.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;

@Repository
public interface CorreoDao extends JpaRepository<Correo, Integer>{

    List<Correo>findByEstudiante(Estudiante estudiante);
    void deleteByEstudiante(Estudiante estudiante);

}
