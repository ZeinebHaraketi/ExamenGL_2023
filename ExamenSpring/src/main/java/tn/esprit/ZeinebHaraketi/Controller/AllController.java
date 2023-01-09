package tn.esprit.elmadhkournasreddine.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.elmadhkournasreddine.Entities.FamilleActe;
import tn.esprit.elmadhkournasreddine.Entities.Pathologie;
import tn.esprit.elmadhkournasreddine.Entities.Patient;
import tn.esprit.elmadhkournasreddine.Services.IServices;
import tn.esprit.elmadhkournasreddine.Services.Services;

import java.util.List;
@RestController
@RequestMapping("")
@AllArgsConstructor
public class AllController {
    private IServices services;

    @PostMapping("ajouterPathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie path) {
        return services.ajouterPathologie(path);
    }

    @PostMapping("ajouterPatientEtAffecterAPathologie/{codePath}")
    public Patient ajouterPatientEtAffecterAPathologie(@RequestBody Patient p,@PathVariable String codePath) {
       return services.ajouterPatientEtAffecterAPathologie(p,codePath);
    }


    @PostMapping("ajouterFamilleActeEtActeAssocie")
    public FamilleActe ajouterFamilleActeEtActeAssocie(@RequestBody FamilleActe facte) {
        return  services.ajouterFamilleActeEtActeAssocie(facte);
    }
    @PostMapping("affecterActeAPathologie/{codeActe}/{codePathologie}")
    public void affecterActeAPathologie(@PathVariable String codeActe,@PathVariable String codePathologie) {
        services.affecterActeAPathologie(codeActe,codePathologie);
    }

    @GetMapping("calculerFacture/{identifiant}")
    public float calculerFacture(@PathVariable String identifiant) {
    return services.calculerFacture(identifiant);
    }




    }
