package org.pet.repository;

import org.pet.repository.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findOptionalByUsernameAndPassword(String username, String password);
}
