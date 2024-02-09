package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SPRINGMVCJPACRUDCFF.dao.CursoDao;
import com.example.SPRINGMVCJPACRUDCFF.dao.EstudianteDao;
import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;
// import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteDao estudianteDao;
    private final CursoDao cursoDao;

    @Override
    public List<Estudiante> dameTodosLosEstudiantes() {
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante dameUnEstudiante(int idEstudiante) {

        return estudianteDao.findById(idEstudiante).get();
    }

    @Override
    public void eliminarEstudiante(int idEstudiante) {

         estudianteDao.deleteById(idEstudiante);

    }

    @Override
    public void persistirEstudiante(Estudiante estudiante) {

        estudianteDao.save(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        
        estudianteDao.save(estudiante);
    }

    @Override
    public List<Estudiante> estudiantesCurso(int idCurso) {
        
        return estudianteDao.findByCurso(cursoDao.findById(idCurso).get());
    }


}
