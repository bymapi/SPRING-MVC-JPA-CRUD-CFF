package com.example.SPRINGMVCJPACRUDCFF;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;
import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;
import com.example.SPRINGMVCJPACRUDCFF.entities.Genero;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;
import com.example.SPRINGMVCJPACRUDCFF.entities.Telefono;
import com.example.SPRINGMVCJPACRUDCFF.services.CorreoService;
import com.example.SPRINGMVCJPACRUDCFF.services.CursoService;
import com.example.SPRINGMVCJPACRUDCFF.services.EstudianteService;
import com.example.SPRINGMVCJPACRUDCFF.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringMvcJpaCrudCffApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;
	private final CursoService cursoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJpaCrudCffApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Curso curso1 = Curso.builder()
				.descripcion("CURSO 1")
				.horario(Horario.DIURNO)
				.build();

		Curso curso2 = Curso.builder()
				.descripcion("CURSO 2")
				.horario(Horario.NOCTURNO)
				.build();
		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);

		Estudiante estudiante1 = Estudiante.builder()
				.nombre("NombreA1")
				.apellidos("ApellidoA1")
				.genero(Genero.MUJER)
				.curso(curso1)
				.fechaMatriculacion(LocalDate.of(2000, 10, 10))
				.curso(cursoService.dameUnCurso(1))
				.totalAsignaturas(5)
				.build();

		estudianteService.persistirEstudiante(estudiante1);

		Estudiante estudiante2 = Estudiante.builder()
				.nombre("NombreA2")
				.apellidos("ApellidoA2")
				.genero(Genero.HOMBRE)
				.curso(curso1)
				.fechaMatriculacion(LocalDate.of(2001, 11, 11))
				.curso(cursoService.dameUnCurso(1))
				.totalAsignaturas(2)
				.build();

		estudianteService.persistirEstudiante(estudiante2);

		Estudiante estudiante3 = Estudiante.builder()
				.nombre("NombreA3")
				.apellidos("ApellidoA3")
				.genero(Genero.MUJER)
				.curso(curso2)
				.fechaMatriculacion(LocalDate.of(2004, 8, 8))
				.curso(cursoService.dameUnCurso(2))
				.totalAsignaturas(1)
				.build();

		estudianteService.persistirEstudiante(estudiante3);

		Estudiante estudiante4 = Estudiante.builder()
				.nombre("NombreA4")
				.apellidos("ApellidoA4")
				.genero(Genero.OTRO)
				.curso(curso2)
				.fechaMatriculacion(LocalDate.of(2005, 3, 12))
				.curso(cursoService.dameUnCurso(2))
				.totalAsignaturas(1)
				.build();

		estudianteService.persistirEstudiante(estudiante4);

		Telefono tlf1Est1 = Telefono.builder()
				.numero("111111")
				.estudiante(estudianteService.dameUnEstudiante(1))
				.build();

		telefonoService.persistirTelefono(1, tlf1Est1);

		Correo correo1est1 = Correo.builder()
				.correo("est1@mail.com")
				.build();

		correoService.persistirCorreo(1, correo1est1);

		Telefono tlf1Est2 = Telefono.builder()
				.numero("22222")
				.estudiante(estudianteService.dameUnEstudiante(2))
				.build();

		telefonoService.persistirTelefono(1, tlf1Est2);

		Correo correo1est2 = Correo.builder()
				.correo("est2@mail.com")
				.build();

		correoService.persistirCorreo(1, correo1est2);

		Telefono tlf1Est3 = Telefono.builder()
				.numero("33333")
				.estudiante(estudianteService.dameUnEstudiante(3))
				.build();

		telefonoService.persistirTelefono(1, tlf1Est3);

		Correo correo1est3 = Correo.builder()
				.correo("est3@mail.com")
				.build();

		correoService.persistirCorreo(1, correo1est3);

	}

}
