package med.vol.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.Specialty;

public record DoctorPostDTO(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		@NotNull
		Specialty speciality,
		@NotNull
		@Valid
		AddressDTO address) {

}
