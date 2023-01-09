package tn.esprit.elmadhkournasreddine.Services;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.elmadhkournasreddine.Entities.Acte;
import tn.esprit.elmadhkournasreddine.Entities.FamilleActe;
import tn.esprit.elmadhkournasreddine.Entities.Pathologie;
import tn.esprit.elmadhkournasreddine.Entities.Patient;
import tn.esprit.elmadhkournasreddine.Repository.ActeRepository;
import tn.esprit.elmadhkournasreddine.Repository.FamilleActeRepository;
import tn.esprit.elmadhkournasreddine.Repository.PathologieRepository;
import tn.esprit.elmadhkournasreddine.Repository.PatientRepository;

import java.util.List;

@AllArgsConstructor @Service
public class Services  implements IServices{

    private ActeRepository acteRepository;
    private FamilleActeRepository familleActeRepository;
    private PathologieRepository pathologieRepository;
    private PatientRepository patientRepository;


    @Override

    public Pathologie ajouterPathologie(Pathologie path) {

        return pathologieRepository.save(path);

    }
    @Override

    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {

        Pathologie pathologie=pathologieRepository.findByCodePath(codePath);
        p.getPathologies().add(pathologie);

        return patientRepository.save(p);

    }
    @Override

    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {

        for (Acte acte : facte.getActes())
        {
            acte.setFamilleActe(facte);
        }

        return familleActeRepository.save(facte);
    }
    @Override

    public void affecterActeAPathologie(String codeActe, String codePathologie){

        Pathologie pathologie = pathologieRepository.findByCodePath(codePathologie);
        Acte acte=acteRepository.findByCodeActe(codeActe);
        if (pathologie.getArchive().booleanValue()!=true){
            pathologie.getActes().add(acte);
            pathologieRepository.save(pathologie);

        }

    }

    @Override
    public float calculerFacture(String identifiant){

        Pathologie pathologie= pathologieRepository.findByCodePath(identifiant);
        if(pathologie==null)
            pathologie=pathologieRepository.findByLibelle(identifiant);


        float somme=0;
        if(pathologie.getArchive().booleanValue()!=true){
            for (Acte acte:pathologie.getActes()){
                somme+= acte.getPrixUnitaireActe()*acte.getCotationActe();
            }
        }


        return somme;
    }



    @Scheduled(cron = "*/30 * * * * *")
    public void calculerNombreActesParPathologie(){

        for (Pathologie pathologie: pathologieRepository.findAll())
        {
            System.out.println("La pathologie : "+pathologie.getDescription()+" Le nombre d'actes : "+String.valueOf(acteRepository.countByPathologies(pathologie)));
        }

    }

}
