package med.vol.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.vol.api.model.Doctor;
import med.vol.api.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
