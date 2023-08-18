package med.vol.api.dtos;

import med.vol.api.Specialty;
import med.vol.api.model.Address;
import med.vol.api.model.Doctor;

public record DoctorDTO(Long id, String nome, String email, String telefone, String crm, Specialty specialty,
                        Address address) {
    public DoctorDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getTelefone(), doctor.getCrm(), doctor.getSpecialty(), doctor.getAddress());
    }
}
