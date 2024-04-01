package com.intern.pentafox.trainingintitute.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentdetails")
public class StudentDetails {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String branch;
    private String course;
    private int age;
}
