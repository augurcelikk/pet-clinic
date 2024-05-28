package org.pet.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pet.utility.enums.PetProcedureType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_pet_doc")
public class PetDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long petId;
    PetProcedureType petProcedureType;
    LocalDate registrationDate;
    Long vetId;
    String description;
    LocalDate nextScheduledDate;
}
