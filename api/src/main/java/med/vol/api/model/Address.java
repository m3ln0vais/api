package med.vol.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import med.vol.api.dtos.AddressDTO;

@Embeddable
@AllArgsConstructor
public class Address {
	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;

	public Address() {

	}

	public Address(AddressDTO addressDTO) {
		this.logradouro = addressDTO.logradouro();
		this.bairro = addressDTO.bairro();
		this.cep = addressDTO.cep();
		this.uf = addressDTO.uf();
		this.cidade = addressDTO.cidade();
		this.numero = addressDTO.numero();
		this.complemento = addressDTO.complemento();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
