package com.sneha.undergrads_management_system.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
//Validation is like a security checkpoint at the entrance. Data must pass the rules before entering the application.

@Entity  //This Java class represents a database entity that should be mapped to a database table.
@Table(name="undergrads")
@Getter//Generates getter methods
@Setter//Generates setter methods
@NoArgsConstructor//Generates a constructor with no arguments
public class Undergrad {
    @Id//uniquely determines each record
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tells db to generate id automatically
    private Long id;

    @NotBlank(message = "First name is required field")
    private String firstName;

    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    @Column(name = "academic_year")
    private Integer year;
}
