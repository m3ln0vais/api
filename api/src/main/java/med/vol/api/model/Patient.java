package med.vol.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import med.vol.api.dtos.PatientPostDTO;
import med.vol.api.dtos.PatientPutDTO;

@Table(name = "patients")
@Entity
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@Embedded
	private Address address;
	private Boolean ativo;

	public Patient(PatientPostDTO postDTO) {
		this.ativo = true;
		this.nome = postDTO.nome();
		this.email = postDTO.email();
		this.telefone = postDTO.telefone();
		this.cpf = postDTO.cpf();
		this.address = new Address(postDTO.address());
	}

	public void atualizar(PatientPutDTO putDTO) {
		if (putDTO.nome() != null) {
			this.nome = putDTO.nome();
		}
		if (putDTO.telefone() != null) {
			this.telefone = putDTO.telefone();
		}
		if (putDTO.address() != null) {
			this.address = putDTO.address();
		}
	}
}
