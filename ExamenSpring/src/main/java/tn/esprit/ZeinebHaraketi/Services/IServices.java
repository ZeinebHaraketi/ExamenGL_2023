package tn.esprit.elmadhkournasreddine.Services;

import tn.esprit.elmadhkournasreddine.Entities.FamilleActe;
import tn.esprit.elmadhkournasreddine.Entities.Pathologie;
import tn.esprit.elmadhkournasreddine.Entities.Patient;

public interface IServices {

    public Pathologie ajouterPathologie(Pathologie path);
    public Patient ajouterPatientEtAffecterAPathologie(Patient p ,String codePath);
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte);
    public void affecterActeAPathologie(String codeActe, String codePathologie);
    public float calculerFacture(String identifiant);

}
