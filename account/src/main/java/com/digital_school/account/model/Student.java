package com.digital_school.account.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends DefaultModel implements Serializable {
private String name;
private String Address;
private String phoneNumber;
private String dob;
private String gradeLevel;
private String classInfo;
private String parent;


}
