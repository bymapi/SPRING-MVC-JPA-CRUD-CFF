package com.example.SPRINGMVCJPACRUDCFF.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;
import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;
import com.example.SPRINGMVCJPACRUDCFF.entities.Telefono;
import com.example.SPRINGMVCJPACRUDCFF.services.CursoService;
import com.example.SPRINGMVCJPACRUDCFF.services.EstudianteService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    
    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    private final Logger LOG = Logger.getLogger("MainController");

   // Punto 4: mostrar listado de los estudiantes matriculados

    @GetMapping("/all")
    public String dameEstudiantes (Model model){

        model.addAttribute("estudiantes",
        estudianteService.dameTodosLosEstudiantes());

        return "views/listadoEstudiantes";
   
    }

    // Punto 5: Formulario de alta/matriculación de alumnos en el curso que se seleccione
    // 5.1. Mappeo para el formulario

    @GetMapping("/frmAltaModif")
    public String formularioAlta (Model model){

        // le paso al modelo un objeto estudiante vacío totalmente
        Estudiante estudiante = new Estudiante();

        model.addAttribute("estudiante",estudiante);

        // También los cursos
        model.addAttribute("cursos",
            cursoService.dameCursos());

        return "views/frmAltaModif";

    }

    // Guardar a un estudiante
    @PostMapping("/persistir")
    @Transactional
    public String persistirEstudiante(@ModelAttribute(name = "estudiante") Estudiante estudiante,
        @RequestParam(name="tlf", required = false) String telefonosRecibidos,
        @RequestParam(name="mails", required = false) String correosRecibidos){

        // Procesar los teléfonos
        
        if (telefonosRecibidos != null) {

            String[] arrayTelefonos = telefonosRecibidos.split(";");
            List<String> numerosTelefonos = Arrays.asList(arrayTelefonos);

            List<Telefono> telefonos = new ArrayList<>();
            
            numerosTelefonos.stream()
                    .forEach(numeroTelefono -> {
                        telefonos.add(Telefono.builder()
                        .numero(numeroTelefono)
                        .estudiante(estudiante)
                        .build());
                    });

            estudiante.setTelefonos(telefonos);
                                            

            
        }

        // Procesar los correos
        if (correosRecibidos != null) {


            String[] arrayCorreos = correosRecibidos.split(";");
            List<String> direccionesCorreos = Arrays.asList(arrayCorreos);

            List<Correo> correos = new ArrayList<>();
            
            direccionesCorreos.stream()
                    .forEach(direccionCorreo-> {
                        correos.add(Correo.builder()
                        .correo(direccionCorreo)
                        .estudiante(estudiante)
                        .build());
                    });

            estudiante.setCorreos(correos);
                                            
            
        }

        estudianteService.persistirEstudiante(estudiante);
        return "redirect:/all";

    }

    // Mostrar los detalles de un estudiante

    @GetMapping("/detalles/{id}")
    public String detallesUnEstudiante (@PathVariable(name = "id") int idEstudiante, Model model) {
        
        LOG.info("ID Employé ok: " + idEstudiante);

        model.addAttribute("estudiante", estudianteService.dameUnEstudiante(idEstudiante));

        return "views/estudianteDetalles";
    }



    // Punto 6: eliminar un estudiante

    @GetMapping("/delete/{id}")
    @Transactional
    public String suprimirEstudiante (@PathVariable(name = "id", required = true) int idEstudiante
                                        ) {
        estudianteService.eliminarEstudiante(idEstudiante);
        return "redirect:/all";

}

    // Punto 7:  Poder modificar/actualizar la información correspondiente a un alumno.

        @GetMapping("/update/{id}")
    @Transactional
    public String modificarEstudiante (@PathVariable(name = "id", required = true) int idEstudiante,
                                        Model model) {
    
    // Recupera el estudiante cuyo id se recibe como parámetro
    
    Estudiante estudiante = estudianteService.dameUnEstudiante(idEstudiante);
    model.addAttribute("estudiante", estudiante);
    
    // Recupero los cursos
    List<Curso> cursos = cursoService.dameCursos();
    model.addAttribute("cursos", cursos);

    // Construir los números de teléfono (separados por ;) a partir de
    // los teléfonos recibidos conjuntamente con el estudiante
    // Y para los correos igual.

    if (estudiante.getTelefonos()!= null) {  
    
    String numerosDeTelefono = estudiante.getTelefonos().stream()
                                .map(Telefono::getNumero)
                                .collect(Collectors.joining(";"));

        model.addAttribute("numerosDeTelefono", numerosDeTelefono);
        }

    if (estudiante.getCorreos()!= null) {  

        String direccionesDeCorreo = estudiante.getCorreos().stream()
                                    .map(Correo::getCorreo)
                                    .collect(Collectors.joining(";"));
    
            model.addAttribute("direccionesDeCorreo", direccionesDeCorreo);
            }

    
    
        return "views/frmAltaModif";


    }

    // Punto 8. Mostrar, mediante un link en la vista, listado de alumnos matriculados en horario de mañana.

    // public List<Estudiante> filtrarPorHorario(Horario horario) {
    //     List<Estudiante> filtrados = new ArrayList<>();
    //         for (Estudiante e : estudianteService.dameTodosLosEstudiantes()) {
    //         if (e.getCurso().getHorario() == horario) {
    //         filtrados.add(e);
    //         }
    //      }
    //         return filtrados;
    // }

    @GetMapping("/listadoHorarioMananas")
    public String listadoHorarioMananas (Model model) {
        
        // model.addAttribute("estudiantes", cursoService.horarioDiurno(null));
        return "views/listadoHorarioMananas";

    }


    // Punto 9. Mostrar, mediante un link en la vista, listado de alumnos agrupados por curso.
    @GetMapping("/listadoEstudiantesCurso")
    public String listadoEstudiantesCurso (Model model){

        return "views/listadoEstudiantesCurso";
    }



}
