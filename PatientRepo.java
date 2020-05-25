package demo.repos;

import demo.classes.Admin;
import demo.classes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo  extends JpaRepository<Patient, Integer> {

    List<Patient> findByLastFirstName(String nom, String prenom);
    List<Patient> findBycin(String cin);
    List<Patient> findBynumserie(int numserie);

    Patient findByid(int id);
}