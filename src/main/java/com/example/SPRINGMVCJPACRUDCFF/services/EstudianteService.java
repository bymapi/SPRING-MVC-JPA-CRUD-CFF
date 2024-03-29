package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;


public interface EstudianteService {

    public List<Estudiante> dameTodosLosEstudiantes();
    public Estudiante dameUnEstudiante(int idEstudiante);
    public void eliminarEstudiante(int idEstudiante);
    public void persistirEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);
    public List<Estudiante> estudiantesCurso(int idCurso);
 

}
