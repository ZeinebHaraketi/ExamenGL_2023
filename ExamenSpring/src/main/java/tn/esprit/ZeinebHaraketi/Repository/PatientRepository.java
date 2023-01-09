package tn.esprit.elmadhkournasreddine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.elmadhkournasreddine.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
