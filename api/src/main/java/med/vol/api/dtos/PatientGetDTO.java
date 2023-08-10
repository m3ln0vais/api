package med.vol.api.dtos;

import med.vol.api.model.Patient;

public record PatientGetDTO(String nome, String email, String cpf) {
	public PatientGetDTO(Patient patient) {
		this(patient.getNome(), patient.getEmail(), patient.getCpf());
	}
}
