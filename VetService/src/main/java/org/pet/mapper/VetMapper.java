package org.pet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.repository.entity.Vet;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VetMapper {
    VetMapper INSTANCE= Mappers.getMapper(VetMapper.class);
    VetSaveRequestDto toDto(final Vet vet);
    Vet toEntity(VetSaveRequestDto dto);
}
