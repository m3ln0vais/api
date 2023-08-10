package med.vol.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.vol.api.model.Address;

public record DoctorPutDTO(
		@NotNull
		Long id, 
		String nome,
		String telefone, 
		String email, 
		Address address) {
	
}
