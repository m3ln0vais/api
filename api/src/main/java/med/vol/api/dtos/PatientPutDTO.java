package med.vol.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.vol.api.model.Address;

public record PatientPutDTO(
		@NotNull
		Long id, 
		String nome,
		String telefone,
		Address address) {

}
