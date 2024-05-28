package org.pet.manager;

import org.pet.dto.request.VetSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${my-application.customer-end-point}",name = "vet")
public interface VetManager {
    @PostMapping("/vets")
    void createVet(@RequestBody VetSaveRequestDto dto);
}
