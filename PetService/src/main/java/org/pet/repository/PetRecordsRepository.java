package org.pet.repository;

import org.pet.repository.entity.PetRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRecordsRepository extends JpaRepository<PetRecords,Long> {
}
