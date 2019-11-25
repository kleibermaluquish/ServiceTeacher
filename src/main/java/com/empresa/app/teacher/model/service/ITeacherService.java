package com.empresa.app.teacher.model.service;

import org.springframework.http.ResponseEntity;

import com.empresa.app.teacher.model.document.Teacher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeacherService {

	public Flux<Teacher> findAll();
	public Mono<Teacher> finById(String id);
	public Mono<Teacher> create(Teacher teacher);
	public Flux<Teacher> findByName(String name);
	public Mono<ResponseEntity<Teacher>> update(Teacher teacher, String id);
	public Mono<Void> deleteById(String id);
}
