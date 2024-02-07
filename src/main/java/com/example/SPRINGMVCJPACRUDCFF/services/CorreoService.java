package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;

public interface CorreoService {

    public List<Correo> correos(int idEstudiante);
    public void eliminarCorreos(int idEstudiante);
    public void persistirCorreo(int idEstudiante, Correo correo);
    public void actualizarCorreo(int idEstudiante, Correo correo);

}
