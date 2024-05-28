package org.pet.repository;

import org.pet.repository.entity.PetDoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRecordsRepository extends JpaRepository<PetDoc,Long> {
}
