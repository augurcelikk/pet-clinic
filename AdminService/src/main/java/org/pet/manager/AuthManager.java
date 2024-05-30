package org.pet.manager;
import org.pet.dto.request.LoginRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${my-auth-application.auth-end-point}",name = "auth")
public interface AuthManager {
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto);

}
