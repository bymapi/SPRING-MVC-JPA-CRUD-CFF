package com.example.SPRINGMVCJPACRUDCFF.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;

@Repository
public interface CursoDao extends JpaRepository<Curso,Integer> {

   List<Curso> findByHorario(Horario horario);

}
