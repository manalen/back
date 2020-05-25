package demo.Controlls;
import demo.classes.*;
import demo.repos.ConsulRepo;
import demo.repos.MedecinRepo;
import demo.repos.PatientRepo;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MedecinController {
    @Autowired
    private MedecinRepo medecinRepo;
    @Autowired
    private ConsulRepo consulRepo;
    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("/med/showallconsu")
    public List<Consultation> showallconsu() {
        return consulRepo.findAll();
    }

    @PostMapping("/med/{medid}/addconsu/{patientid}")
    public Consultation createconsu(@PathVariable(value = "medid") int medid, @PathVariable(value="patientid") int patientid,@RequestBody Consultation consultation) {
        return medecinRepo.findById(medid).map(medecin -> {
            consultation.setMedecin(medecin);
            consultation.setPatient(patientRepo.findById(patientid).get());
            return consulRepo.save(consultation);
        }).orElseThrow(() -> new ResourceNotFoundException("medecin id " + medid + " not found"));
    }

    @GetMapping("/med/showallpatient")
    public List<Patient> showallpatient() {return patientRepo.findAll();
    }

    @GetMapping("/med/showpatientbyid/{id}")
    public Patient showpatientbyid(@PathVariable(value="id") int id) {
        return patientRepo.findById(id).get();
    }

    @GetMapping("/med/showapatientbyname/{last}/{first}")
    public List<Patient> showpatientbyname(@PathVariable String last,@PathVariable String first ) {
        return patientRepo.findByLastFirstName(last,first);
    }

    @GetMapping("/med/showpatientbycin/{cin}")
    public List<Patient> showpatientbycin(@PathVariable String cin) {
        return patientRepo.findBycin(cin);
    }

    @GetMapping("/med/showpatientbynum/{numserie}")
    public List<Patient> showpatientbynum(@PathVariable int numserie) {
        return patientRepo.findBynumserie(numserie);
    }
}