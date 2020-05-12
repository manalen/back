package com.springoot.CabMed.Firstus;


import com.springoot.CabMed.Connection.Consultationdb;
import com.springoot.CabMed.Connection.Medecindb;
import com.springoot.CabMed.Connection.Patientdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springoot.CabMed.Class.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FirstusService {
    @Autowired
    private Patientdb patientdb;



    public List<Patient> findall() {
        return patientdb.findAll();

    }

    public Patient getbyid(int i) {
        return patientdb.findById(i).get();
    }

  /*  public List<Patient> findbyname(String nom, String prenom) {
        return patientdb.

    }*/

   /* public List<Patient> finfbycin(String carte) {
        List<Patient> liste = new ArrayList<Patient>();
        for (Patient k : data) {
            if (k.getCin() == carte) {
                liste.add(k);
            }

        }
        return liste;
    }*/

    public Patient save(Patient e) {
        return patientdb.insert(e)==null? e : null;

    }

    public List<Patient> getbycin(String cin) {
        return patientdb.findByCin(cin);
    }
     /* public void delete(int k ){
          patientdb.deleteById(k);
      }*/
   /* public Medecin returnmedcin(int id) {
        return medecindb.findById(id).get();

    }

    public boolean savemedecin(Medecin e) {
      return medecindb.insert(e)==null ? true : false ;
    }*/
}
