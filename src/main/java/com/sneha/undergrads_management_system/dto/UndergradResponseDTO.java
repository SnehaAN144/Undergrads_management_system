package com.sneha.undergrads_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UndergradResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private Integer age;
}