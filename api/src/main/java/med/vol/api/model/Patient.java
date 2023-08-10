package med.vol.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.vol.api.dtos.PatientPostDTO;
import med.vol.api.dtos.PatientPutDTO;

@Table(name = "patients")
@Entity
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

	public Patient(PatientPostDTO postDTO) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
