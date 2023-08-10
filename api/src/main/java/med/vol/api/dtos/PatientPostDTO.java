package med.vol.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientPostDTO(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		String cpf,
		@NotNull
		@Valid
		AddressDTO address) {

}
