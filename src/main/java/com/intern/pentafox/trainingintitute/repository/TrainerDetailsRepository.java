package com.intern.pentafox.trainingintitute.repository;

import com.intern.pentafox.trainingintitute.entity.TrainerDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerDetailsRepository extends CrudRepository< TrainerDetails, Integer> {
    TrainerDetails findBytrainerName(String trainerName);
    @Query(value ="SELECT * FROM trainer_details WHERE sal>=26000", nativeQuery = true)
    List<TrainerDetails> getsaloftrainers();
}
