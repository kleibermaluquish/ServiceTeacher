package com.empresa.app.teacher;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.empresa.app.teacher.model.dao.ITeacherDao;
import com.empresa.app.teacher.model.document.Teacher;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ServiceTeacherApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceTeacherApplication.class);
	
	@Autowired
	private ITeacherDao dao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ServiceTeacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("Teacher").subscribe();
			
		
		Flux.just(
			new Teacher("Mariana", "Saavedra", "F", "Algoritmica I", new ArrayList<String>()),
			new Teacher("Marcos", "Sotelo", "M", "Base de Datos", new ArrayList<String>()),
			new Teacher("Robert", "Quiroz", "M", "Circuitos Digitales", new ArrayList<String>())
			)
		.flatMap(teacher -> dao.save(teacher))
		.subscribe(teacher -> log.info("Id: "+teacher.getId()+ " Nombre: "+teacher.getFirsName()));
		
	}

}


