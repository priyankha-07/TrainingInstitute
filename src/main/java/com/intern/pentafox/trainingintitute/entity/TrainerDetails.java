package com.intern.pentafox.trainingintitute.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TrainerDetails")
public class TrainerDetails {
    @Id
    @GeneratedValue
    private int id;
    private String trainerName;
    private double sal;
    private String courseHandled;
    private int experience;


}
