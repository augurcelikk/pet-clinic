package org.pet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetSaveRequestDto {
    String name;
    String surname;
    String email;
    String phone;
    Long companyId;
    Long appointmentId;
    String specialization;
}
