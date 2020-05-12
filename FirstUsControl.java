package com.springoot.CabMed.Firstus;

import com.springoot.CabMed.Class.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/medecin")
public class FirstusControl {

    @Autowired
    private FirstusService ResultService;


    @GetMapping(value = {"/AfficherToutPatient"})

    public ResponseEntity< List<Patient>> todosALL() {
        return new   ResponseEntity<> (ResultService.findall(), HttpStatus.OK);


    }

    @GetMapping(value = {"/AfficherPatientById/{id_patient}"})
    public ResponseEntity<Patient> findByid(@PathVariable int id_patient) {
        return new ResponseEntity<> (ResultService.getbyid(id_patient),HttpStatus.OK);
    }

  /*  @GetMapping(value = {"AfficherPatientByNomprenom/{nom}/{prenom}"})
    public List<Patient> findByName(@PathVariable String nom, @PathVariable String prenom) {
        return ResultService.findbyname(nom, prenom);
    }*/

    @GetMapping(value = {"AfficherPatientByCin/{cin}"})
    public List<Patient> findByCin(@PathVariable String cin) {
        return ResultService.getbycin(cin);
    }
    //

    //    }

    @PostMapping(value = {"/CreerPatient"})
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient o) {
        Patient i = ResultService.save(o);
        return new ResponseEntity<> (ResultService.save(o),HttpStatus.CREATED);


    }

    /*  @GetMapping(value={"/{id_med"})
       public Medecin affichermedecin(@PathVariable int  id_med){
          return ResultService.returnmedcin(id_med);

       }*/
   /* @PostMapping(value={"creermedecin"})
    public Medecin inserermedecin(@RequestBody Medecin o){
       if(ResultService.savemedecin(o)){
           return o ;
       }
       else{
           return null;
       }
    }*/
    @PostMapping(value = {"/ModifierProfil"})
    public Medecin updatemed(@RequestBody Medecin Medecino) {


        return Medecino;
    }
}
