package com.intern.pentafox.trainingintitute.repository;

import com.intern.pentafox.trainingintitute.entity.StudentDetails;
import com.intern.pentafox.trainingintitute.entity.TrainerDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDetailsRepository extends CrudRepository<StudentDetails, Integer> {

    @Query(value = "SELECT * FROM studentdetails WHERE name=?", nativeQuery = true)
    StudentDetails findByName(String name);



  @Modifying
  @Transactional
  @Query(value = "INSERT INTO studentdetails(id, name, branch, course,age) VALUES (studentId,studentName,studentBranch,)", nativeQuery = true)

    void  addNewstudent(@Param("studentId") int id, @Param("studentName")String name, @Param("studentBranch")String branch,@Param("studentCourse") String course, @Param("studentAge") int age);

  @Modifying
  @Transactional
  @Query(value="SELECT * FROM studentdetails s inner join trainer_details t On s.id= t.id", nativeQuery = true)
  List<Object[]> getalldetails();

  @Modifying
  @Transactional
  @Query(value="SELECT * FROM studentdetails s inner join trainer_details t On  s.id = t.id WHERE s.age>=18",nativeQuery = true)
    List<Object[]>getalldetailsusingage();

  @Modifying
    @Transactional
    @Query(value = "UPDATE studentdetails  SET age =10 WHERE  id=1",nativeQuery = true)
    void ageofusers();


}



