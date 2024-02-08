package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;
public interface CursoService {

    public List<Curso> dameCursos();
    public Curso dameUnCurso(int idCurso);
    public void persistirCurso(Curso curso);
    // public List<Curso> horarioDiurno(Horario horario);

}
