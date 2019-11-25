package com.empresa.app.teacher.model.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empresa.app.teacher.model.dao.ITeacherDao;
import com.empresa.app.teacher.model.document.Teacher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeacherServiceImple implements ITeacherService {

	@Autowired
	private ITeacherDao dao;

	@Override
	public Flux<Teacher> findAll() {

		return dao.findAll();
	}

	@Override
	public Mono<Teacher> finById(String id) {

		return dao.findById(id);
	}

	@Override
	public Mono<Teacher> create(Teacher teacher) {

		return dao.save(teacher);
	}

	@Override
	public Flux<Teacher> findByName(String name) {

		return dao.findAll().filter(p -> p.getFirsName().equals(name));
	}

	@Override
	public Mono<ResponseEntity<Teacher>> update(Teacher teacher, String id) {

		return dao.findById(id).flatMap(p -> {
			p.setFirsName(teacher.getFirsName());
			p.setLastName(teacher.getLastName());
			p.setCurso(teacher.getCurso());
			p.setGender(teacher.getGender());
			p.setFamilyRelative(teacher.getFamilyRelative());

			return dao.save(p);
		}).map(s -> ResponseEntity.created(URI.create("/api/teacher/".concat(s.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@Override
	public Mono<Void> deleteById(String id) {

		return dao.deleteById(id);
	}

}
