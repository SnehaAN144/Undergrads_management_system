package com.sneha.undergrads_management_system.dto;

import com.sneha.undergrads_management_system.entity.Undergrad;

public class UndergradMapper {

    // Convert Request DTO to Entity
    public static Undergrad toEntity(UndergradRequestDTO dto) {

        Undergrad undergrad = new Undergrad();

        undergrad.setFirstName(dto.getFirstName());
        undergrad.setLastName(dto.getLastName());
        undergrad.setEmail(dto.getEmail());
        undergrad.setPhoneNumber(dto.getPhoneNumber());
        undergrad.setDepartment(dto.getDepartment());
        undergrad.setAge(dto.getAge());

        return undergrad;
    }

    // Convert Entity to Response DTO
    public static UndergradResponseDTO toResponseDTO(Undergrad undergrad) {

        UndergradResponseDTO dto = new UndergradResponseDTO();

        dto.setId(undergrad.getId());
        dto.setFirstName(undergrad.getFirstName());
        dto.setLastName(undergrad.getLastName());
        dto.setEmail(undergrad.getEmail());
        dto.setPhoneNumber(undergrad.getPhoneNumber());
        dto.setDepartment(undergrad.getDepartment());
        dto.setAge(undergrad.getAge());

        return dto;
    }
}