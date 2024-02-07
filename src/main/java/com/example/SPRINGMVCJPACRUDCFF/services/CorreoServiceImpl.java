package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SPRINGMVCJPACRUDCFF.dao.CorreoDao;
import com.example.SPRINGMVCJPACRUDCFF.dao.EstudianteDao;
import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CorreoServiceImpl implements CorreoService{


    private final CorreoDao correoDao;
    private final EstudianteDao estudianteDao;
    @Override
    public List<Correo> correos(int idEstudiante) {

        return correoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

    @Override
    public void eliminarCorreos(int idEstudiante) {
        correoDao.deleteByEstudiante(estudianteDao.findById(idEstudiante).get());

    }
    @Override
    public void persistirCorreo(int idEstudiante, Correo correo) {
        correo.setEstudiante(estudianteDao.findById(idEstudiante).get());
        correoDao.save(correo);
    }
    @Override
    public void actualizarCorreo(int idEstudiante, Correo correo) {
        correo.setEstudiante(estudianteDao.findById(idEstudiante).get());
        correoDao.save(correo);

    }



}
