package com.empresa.app.teacher.model.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Teacher")
public class Teacher {

	@Id
	private String id;
	private String firsName;
	private String lastName;
	private String gender;
	private String curso;
	private List<String> familyRelative;

	public Teacher() {}

	public Teacher(String firsName, String lastName, String gender, String curso, List<String> familyRelative) {
		this.firsName = firsName;
		this.lastName = lastName;
		this.gender = gender;
		this.curso = curso;
		this.familyRelative = familyRelative;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<String> getFamilyRelative() {
		return familyRelative;
	}

	public void setFamilyRelative(List<String> familyRelative) {
		this.familyRelative = familyRelative;
	}

}
