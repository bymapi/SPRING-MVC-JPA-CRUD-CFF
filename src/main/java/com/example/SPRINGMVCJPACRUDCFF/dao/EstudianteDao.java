package com.example.SPRINGMVCJPACRUDCFF.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;
// import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;

@Repository
public interface EstudianteDao extends JpaRepository<Estudiante,Integer>{

    List<Estudiante>findByNombre(String nombre);
    List<Estudiante> findByCurso(Curso curso);
    // List<Estudiante> findByHorario(Curso curso);


}
