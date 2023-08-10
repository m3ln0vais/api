package med.vol.api.dtos;

import med.vol.api.Specialty;
import med.vol.api.model.Doctor;

public record DoctorGetDTO(String nome, String email, String crm, Specialty specialty) {
	public DoctorGetDTO(Doctor doctor) {
		this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
	}
}
