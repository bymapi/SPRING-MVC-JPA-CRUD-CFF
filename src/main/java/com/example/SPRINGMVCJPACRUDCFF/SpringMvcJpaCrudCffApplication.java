package com.example.SPRINGMVCJPACRUDCFF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SPRINGMVCJPACRUDCFF.entities.Correo;
import com.example.SPRINGMVCJPACRUDCFF.entities.Curso;
import com.example.SPRINGMVCJPACRUDCFF.entities.Estudiante;
import com.example.SPRINGMVCJPACRUDCFF.entities.Genero;
import com.example.SPRINGMVCJPACRUDCFF.entities.Horario;
import com.example.SPRINGMVCJPACRUDCFF.entities.Telefono;
import com.example.SPRINGMVCJPACRUDCFF.services.CursoService;
import com.example.SPRINGMVCJPACRUDCFF.services.CorreoService;
import com.example.SPRINGMVCJPACRUDCFF.services.EstudianteService;
import com.example.SPRINGMVCJPACRUDCFF.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringMvcJpaCrudCffApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;
	private final CursoService cursoService;
	private final CorreoService correoService;
	private final TelefonoService telefonoService;

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
				.nombreFoto("womanSmiling2.jpg")
				.curso(curso1)
				.fechaMatriculacion(LocalDate.of(2000, 10, 10))
				.totalAsignaturas(5)
				.build();


		Estudiante estudiante2 = Estudiante.builder()
				.nombre("NombreA2")
				.apellidos("ApellidoA2")
				.genero(Genero.HOMBRE)
				.nombreFoto("manSmiling1.jpg")
				.curso(curso1)
				.fechaMatriculacion(LocalDate.of(2001, 11, 11))
				.totalAsignaturas(2)
				.build();


		Estudiante estudiante3 = Estudiante.builder()
				.nombre("NombreA3")
				.apellidos("ApellidoA3")
				.genero(Genero.MUJER)
				.nombreFoto("chicaImg1.jpg")
				.curso(curso2)
				.fechaMatriculacion(LocalDate.of(2004, 8, 8))
				.totalAsignaturas(1)
				.build();


		Estudiante estudiante4 = Estudiante.builder()
				.nombre("NombreA4")
				.apellidos("ApellidoA4")
				.genero(Genero.OTRO)
				.curso(curso2)
				.fechaMatriculacion(LocalDate.of(2005, 3, 12))
				.totalAsignaturas(1)
				.build();

		estudianteService.persistirEstudiante(estudiante1);
		estudianteService.persistirEstudiante(estudiante2);
		estudianteService.persistirEstudiante(estudiante3);
		estudianteService.persistirEstudiante(estudiante4);
		

		List<Telefono> telefonosEst1 = new ArrayList<>();
		List<Correo> correosEst1 = new ArrayList<>();
		List<Telefono> telefonosEst2 = new ArrayList<>();
		List<Correo> correosEst2 = new ArrayList<>();
		List<Telefono> telefonosEst3 = new ArrayList<>();
		List<Correo> correosEst3 = new ArrayList<>();
		List<Telefono> telefonosEst4 = new ArrayList<>();
		List<Correo> correosEst4 = new ArrayList<>();


		Telefono tlf1Est1 = Telefono.builder()
				.numero("111111")
				.estudiante(estudiante1)
				.build();


		Correo correo1est1 = Correo.builder()
				.correo("est1@mail.com")
				.estudiante(estudiante1)
				.build();


		Telefono tlf1Est2 = Telefono.builder()
				.numero("22222")
				.estudiante(estudiante2)
				.build();

		Correo correo1est2 = Correo.builder()
				.correo("est2@mail.com")
				.estudiante(estudiante2)
				.build();


		Telefono tlf1Est3 = Telefono.builder()
				.numero("33333")
				.estudiante(estudiante3)
				.build();


		Correo correo1est3 = Correo.builder()
				.correo("est3@mail.com")
				.estudiante(estudiante3)
				.build();

		Telefono tlf1Est4 = Telefono.builder()
				.numero("33333")
				.estudiante(estudiante4)
				.build();


		Correo correo1est4 = Correo.builder()
				.correo("est3@mail.com")
				.estudiante(estudiante4)
				.build();
		
		telefonosEst1.add(tlf1Est1);
		telefonosEst2.add(tlf1Est2);
		telefonosEst3.add(tlf1Est3);
		telefonosEst4.add(tlf1Est4);
		correosEst1.add(correo1est1);
		correosEst2.add(correo1est2);
		correosEst3.add(correo1est3);
		correosEst4.add(correo1est4);
		
		estudiante1.setTelefonos(telefonosEst1);
		estudiante1.setCorreos(correosEst1);
		estudiante2.setTelefonos(telefonosEst2);
		estudiante2.setCorreos(correosEst2);
		estudiante3.setTelefonos(telefonosEst3);
		estudiante3.setCorreos(correosEst3);
		estudiante4.setTelefonos(telefonosEst4);
		estudiante4.setCorreos(correosEst4);


 
	}

}
