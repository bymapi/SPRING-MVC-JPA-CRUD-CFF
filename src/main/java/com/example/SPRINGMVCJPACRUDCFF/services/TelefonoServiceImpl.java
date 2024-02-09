 package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SPRINGMVCJPACRUDCFF.dao.EstudianteDao;
import com.example.SPRINGMVCJPACRUDCFF.dao.TelefonoDao;
import com.example.SPRINGMVCJPACRUDCFF.entities.Telefono;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TelefonoServiceImpl implements TelefonoService{

    private final TelefonoDao telefonoDao;
    private final EstudianteDao estudianteDao;

    @Override
    public List<Telefono> telefonos(int idEstudiante) {

        return telefonoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
    }


    @Override
    public void persistirTelefono(int idEstudiante,Telefono telefono ) {
        telefono.setEstudiante(estudianteDao.findById(idEstudiante).get());
        telefonoDao.save(telefono);
    }

    @Override
    public void actualizarTelefono(int idEstudiante, Telefono telefono) {

        telefono.setEstudiante(estudianteDao.findById(idEstudiante).get());
        telefonoDao.save(telefono);
    }

    @Override
    public void eliminarTelefonos(int idEstudiante) {
        telefonoDao.deleteByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

}
 