package med.vol.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.dtos.DoctorDTO;
import med.vol.api.dtos.DoctorGetDTO;
import med.vol.api.dtos.DoctorPostDTO;
import med.vol.api.dtos.DoctorPutDTO;
import med.vol.api.model.Doctor;
import med.vol.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastar(@RequestBody @Valid DoctorPostDTO doctorPostDTO, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(doctorPostDTO);
        doctorRepository.save(doctor);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorGetDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        //converter dto
        //return doctorRepository.findAll(pageable).stream().map(DoctorGetDTO::new).toList();
        var page = doctorRepository.findAllByAtivoTrue(pageable).map(DoctorGetDTO::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DoctorPutDTO doctorPutDTO) {
        var doctor = doctorRepository.getReferenceById(doctorPutDTO.id());
        doctor.atualizar(doctorPutDTO);

        return ResponseEntity.ok(new DoctorDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDTO(doctor));
    }
}
