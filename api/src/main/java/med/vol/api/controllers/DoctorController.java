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
import med.vol.api.dtos.DoctorGetDTO;
import med.vol.api.dtos.DoctorPostDTO;
import med.vol.api.dtos.DoctorPutDTO;
import med.vol.api.model.Doctor;
import med.vol.api.repositories.DoctorRepository;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping
	@Transactional
	public void cadastar(@RequestBody @Valid DoctorPostDTO doctorPostDTO) {
		doctorRepository.save(new Doctor(doctorPostDTO));
	}

	@GetMapping
	public Page<DoctorGetDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
		// converter dto
//		return doctorRepository.findAll(pageable).stream().map(DoctorGetDTO::new).toList();
		return doctorRepository.findAllByAtivoTrue(pageable).map(DoctorGetDTO::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DoctorPutDTO doctorPutDTO) {
		var doctor = doctorRepository.getReferenceById(doctorPutDTO.id());
		doctor.atualizar(doctorPutDTO);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var doctor = doctorRepository.getReferenceById(id);
		doctor.excluir();
	}
}
