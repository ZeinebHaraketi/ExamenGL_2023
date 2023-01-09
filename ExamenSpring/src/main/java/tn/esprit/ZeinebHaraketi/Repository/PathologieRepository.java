package tn.esprit.elmadhkournasreddine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.elmadhkournasreddine.Entities.Pathologie;

public interface PathologieRepository extends JpaRepository<Pathologie,Long> {

    Pathologie findByCodePath(String codePath);

    Pathologie findByLibelle(String identifiant);
}
