package com.springoot.CabMed.Connection;


import com.springoot.CabMed.Class.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface Patientdb  extends MongoRepository<Patient, Integer> {
    @Query("{'Patientdb.cin':?0}")
    List<Patient> findByCin(String cin);

    List<Patient> findByName(String nom, String prenom);

}
