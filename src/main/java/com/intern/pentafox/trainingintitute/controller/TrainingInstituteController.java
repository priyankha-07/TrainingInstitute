package com.intern.pentafox.trainingintitute.controller;

import com.intern.pentafox.trainingintitute.entity.StudentDetails;
import com.intern.pentafox.trainingintitute.entity.TrainerDetails;
import com.intern.pentafox.trainingintitute.service.TrainingInstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institute")
public class TrainingInstituteController {
    @Autowired
    private TrainingInstituteService service;

    @PostMapping("/adddetailsofstudent")
    public StudentDetails addStudentDetails(@RequestBody StudentDetails studentdetail){
        return service.savestudentdetail(studentdetail);
    }
    @PostMapping("/adddetailsoftrainer")
    public TrainerDetails addTrainerDetails(@RequestBody TrainerDetails trainerdetail){
        return service.savetrainerdetail(trainerdetail);
    }

    @PostMapping("/addlistofstudents")
    public Iterable<StudentDetails> addStudentDetails(@RequestBody List<StudentDetails> studentdetails){
        return service.saveAllstudentdetails(studentdetails);
    }
    @PostMapping("/addlistoftrainers")
    public Iterable<TrainerDetails> addTrainerDetails(@RequestBody List<TrainerDetails> trainerdetails){
        return service.saveAlltrainerdetails(trainerdetails);
    }

    @GetMapping("/displayallstudents")
    public  Iterable<StudentDetails> findAllStudentDetails(){
        return service.getstudentdetails();
    }
    @GetMapping("/displayalltrainers")
    public  Iterable<TrainerDetails> findAllTrainerDetails(){
        return service.gettrainerdetails();
    }

   @GetMapping("/getstudentByid/{id}")
   public StudentDetails findstudentdetailById(@PathVariable int id){
        return service.getstudentdetailById(id);
    }
    @GetMapping("/gettrainerByid/{id}")
    public TrainerDetails findtrainerdetailById(@PathVariable int id){
        return service.gettrainerdetailById(id);
    }
    @GetMapping("/getstudentByName/{name}")
    public StudentDetails findstudentdetailByName(@PathVariable String name){
        return service.getstudentdetailByName(name);
    }
    @GetMapping("/gettrainerByName/{name}")
    public TrainerDetails findtrainerdetailByName(@PathVariable String name){
        return service.gettrainerdetailByName(name);
    }
   @PutMapping("/updatestudent")
   public StudentDetails updatestudentdetail(@RequestBody StudentDetails studentdetail){
        return service.updatestudentdetail(studentdetail);
    }
    @PutMapping("/updatetrainer")
    public TrainerDetails updatetrainerdetail(@RequestBody TrainerDetails trainerdetail){
        return service.updatetrainerdetail(trainerdetail);
    }
    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudentDetailById(@PathVariable int id){
        service.deleteStudentDetails(id);
        return "Successfully deleted";
    }
    @DeleteMapping("/deletetrainer/{id}")
    public String deletetrainerDetailById(@PathVariable int id){
        service.deleteTrainerDetails(id);
        return "Successfully deleted";
    }
   @PostMapping("/addnewstudent")
   public String addnewstudent(@RequestBody StudentDetails students) {
       service.addNewStudent(  students);
       return "Successfully added";
   }
   @GetMapping("/getalluserdetailsbyjoin")
   public List<Object[]> getObjectsdata(){
        return service.getalluserdetails();
   }
   @GetMapping("/getallusersbyage")
    public List<Object[]>getuserage(){
        return service.getuserbyage();
   }
   @PutMapping("/updatetheageofuser")
    public  String setthenewage(){
        service.updatingtheage();
        return "Sucessfully updated";
   }
   @GetMapping("/displaysal")
    public List <TrainerDetails >displaysaloftrainers(){
        return service.fetchsaloftrainers();
   }
}
