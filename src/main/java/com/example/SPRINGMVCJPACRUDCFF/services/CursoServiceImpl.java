package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SPRINGMVCJPACRUDCFF.dao.CursoDao;
import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    @Override
    public List<Curso> dameCursos() {

        return cursoDao.findAll();

    }

    @Override
    public Curso dameUnCurso(int idCurso) {
    
        return cursoDao.findById(idCurso).get();

    }

    @Override
    public void persistirCurso(Curso curso) {

        cursoDao.save(curso);
    }

    @Override
    public List<Curso> horarioDiurno(Horario horario) {
        
        return cursoDao.findByHorario(horario);

    }



}
