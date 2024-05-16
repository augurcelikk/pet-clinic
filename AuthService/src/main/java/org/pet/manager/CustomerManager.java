package org.pet.manager;

import org.pet.dto.request.CustomerSaveRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "${my-application.customer-end-point}",name = "customer")
public interface CustomerManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody @Valid CustomerSaveRequestDto dto);
}
