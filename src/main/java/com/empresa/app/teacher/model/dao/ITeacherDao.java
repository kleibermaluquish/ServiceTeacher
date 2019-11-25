package com.empresa.app.teacher.model.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.empresa.app.teacher.model.document.Teacher;

@Repository
public interface ITeacherDao extends ReactiveMongoRepository<Teacher, String> {

}
