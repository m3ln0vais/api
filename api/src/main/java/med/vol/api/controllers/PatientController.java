package med.vol.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.dtos.PatientGetDTO;
import med.vol.api.dtos.PatientPostDTO;
import med.vol.api.dtos.PatientPutDTO;
import med.vol.api.model.Patient;
import med.vol.api.repositories.PatientRepository;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@PostMapping
	@Transactional
	public void cadastar(@RequestBody @Valid PatientPostDTO patientPostDTO) {
		patientRepository.save(new Patient(patientPostDTO));
	}

	@GetMapping
	public Page<PatientGetDTO> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable pageable) {
		return patientRepository.findAll(pageable).map(PatientGetDTO::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid PatientPutDTO putDTO) {
		var patient = patientRepository.getReferenceById(putDTO.id());
		patient.atualizar(putDTO);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		patientRepository.deleteById(id);
	}
}
