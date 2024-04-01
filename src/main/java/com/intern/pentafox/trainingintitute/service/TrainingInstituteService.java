package com.intern.pentafox.trainingintitute.service;

import com.intern.pentafox.trainingintitute.entity.StudentDetails;

import com.intern.pentafox.trainingintitute.entity.TrainerDetails;
import com.intern.pentafox.trainingintitute.repository.StudentDetailsRepository;
import com.intern.pentafox.trainingintitute.repository.TrainerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingInstituteService {
   @Autowired
   private StudentDetailsRepository repository;
   @Autowired
   private TrainerDetailsRepository repository1;

   public StudentDetails savestudentdetail(StudentDetails studentdetail){
       return repository. save(studentdetail);
    }
    public TrainerDetails savetrainerdetail(TrainerDetails trainerdetail){
        return repository1. save(trainerdetail);
    }
   public Iterable<StudentDetails> saveAllstudentdetails(Iterable<StudentDetails> studentdetails){
       return repository.saveAll(studentdetails);

   }
    public Iterable<TrainerDetails> saveAlltrainerdetails(Iterable<TrainerDetails> trainerdetails){
        return repository1.saveAll(trainerdetails);

    }
   public Iterable<StudentDetails>getstudentdetails(){
       return repository.findAll();
   }
    public Iterable<TrainerDetails>gettrainerdetails(){
        return repository1.findAll();
    }
   public StudentDetails getstudentdetailById(int id){
       return repository.findById(id).orElse(null);
   }
    public TrainerDetails gettrainerdetailById(int id){
        return repository1.findById(id).orElse(null);
    }
   public StudentDetails getstudentdetailByName(String name){
       return repository.findByName(name);

   }
    public TrainerDetails gettrainerdetailByName(String trainerName){
        return repository1.findBytrainerName(trainerName);

    }
   public StudentDetails updatestudentdetail (StudentDetails studentdetail){
       StudentDetails s = repository.findById(studentdetail.getId()).orElse(null);
       s.setName(studentdetail.getName());
       s.setAge(studentdetail.getAge());
       s.setBranch(studentdetail.getBranch());
       s.setCourse(studentdetail.getCourse());
       return repository.save(s);
   }
    public TrainerDetails updatetrainerdetail (TrainerDetails trainerdetail){
        TrainerDetails t = repository1.findById(trainerdetail.getId()).orElse(null);
        t.setTrainerName(trainerdetail.getTrainerName());
        t.setExperience(trainerdetail.getExperience());
        t.setSal(trainerdetail.getSal());
        t.setCourseHandled(trainerdetail.getCourseHandled());

        return repository1.save(t);
    }

   public String deleteStudentDetails(int id){
       repository.deleteById(id);
       return "deleted successfully"+id;

   }
    public String deleteTrainerDetails(int id){
        repository1.deleteById(id);
        return "deleted successfully"+id;

    }
    public void addNewStudent(StudentDetails student) {
        repository.addNewstudent(student.getId(),student.getName(),student.getBranch(),student.getCourse(), student.getAge());
    }
   public  List<Object[]> getalluserdetails(){
      return repository.getalldetails();
}
 public List<Object[]>getuserbyage(){
       return repository.getalldetailsusingage();
 }
 public void  updatingtheage(){
       repository.ageofusers();

 }public List<TrainerDetails> fetchsaloftrainers(){
       return repository1. getsaloftrainers();
    }
}
