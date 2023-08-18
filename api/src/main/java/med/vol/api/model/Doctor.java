package med.vol.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import med.vol.api.Specialty;
import med.vol.api.dtos.DoctorPostDTO;
import med.vol.api.dtos.DoctorPutDTO;

@Table(name = "doctors")
@Entity
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;
    private Boolean ativo;

    public Doctor(DoctorPostDTO doctorDTO) {
        this.ativo = true;
        this.nome = doctorDTO.nome();
        this.email = doctorDTO.email();
        this.telefone = doctorDTO.telefone();
        this.crm = doctorDTO.crm();
        this.specialty = doctorDTO.speciality();
        this.address = new Address(doctorDTO.address());
    }

    public void atualizar(DoctorPutDTO doctorPutDTO) {
        if (doctorPutDTO.nome() != null) {
            this.nome = doctorPutDTO.nome();
        }
        if (doctorPutDTO.telefone() != null) {
            this.telefone = doctorPutDTO.telefone();
        }
        if (doctorPutDTO.address() != null) {
            this.address = doctorPutDTO.address();
        }
    }

    public void excluir() {
        this.ativo = false;

    }
}
