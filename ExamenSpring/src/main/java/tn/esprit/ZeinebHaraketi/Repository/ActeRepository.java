package tn.esprit.elmadhkournasreddine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.elmadhkournasreddine.Entities.Acte;
import tn.esprit.elmadhkournasreddine.Entities.Pathologie;

public interface ActeRepository extends JpaRepository<Acte,Long> {
    Acte findByCodeActe(String codeActe);

    Integer countByPathologies(Pathologie pathologie);


}
