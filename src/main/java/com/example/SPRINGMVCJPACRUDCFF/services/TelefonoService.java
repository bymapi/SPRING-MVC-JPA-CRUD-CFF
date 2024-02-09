package com.example.SPRINGMVCJPACRUDCFF.services;

import java.util.List;

import com.example.SPRINGMVCJPACRUDCFF.entities.Telefono;

public interface TelefonoService {

    public List<Telefono> telefonos(int idEstudiante);
    public void eliminarTelefonos(int idEstudiante);
    public void persistirTelefono(int idEstudiante, Telefono telefono);
    public void actualizarTelefono(int idEstudiante, Telefono telefono);

}
 