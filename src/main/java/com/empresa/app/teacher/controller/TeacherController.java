package com.empresa.app.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.app.teacher.model.document.Teacher;
import com.empresa.app.teacher.model.service.ITeacherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private ITeacherService service;

	// LISTAR ESTUDIANTES
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/listar")
	
	public Flux<Teacher> listStudent() {
		Flux<Teacher> studentList = service.findAll();

		return studentList;
	}

	// LISTAR ESTUDIANTE POR ID
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Mono<Teacher> showById(@PathVariable String id) {
		Mono<Teacher> student = service.finById(id);

		return student;
	}

	

	// GUARDAR UN ESTUDIANTE
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Teacher> create(@RequestBody Teacher teacher) {
		return service.create(teacher);
	}

	// EDITAR UN ESTUDIANTE POR ID
	
	 @PutMapping("/{id}")	  
	 @ResponseStatus(HttpStatus.CREATED) 
	 public Mono<ResponseEntity<Teacher>> updateStudent(@RequestBody Teacher teacher, @PathVariable String id){
	  
	 return service.update(teacher, id); 
	 }
	 

	// ELIMINAR UN ESTUDIANTE POR ID
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	
	
	public Mono<Void> delete(@PathVariable String id) {
		Mono<Void> deletTeacher = service.deleteById(id);

		return deletTeacher;
	}

}
