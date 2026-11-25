package com.sneha.undergrads_management_system.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @NotBlank(message = "Last name is required field")
    private String lastName;

    @NotBlank(message = "email is required field")
    @Email(message = "please enter valid email")
    @Size(max=150,message = "cannot exceed 150 characters")
    @Column(nullable = false,unique = true,length = 150)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

    @NotBlank(message = "Department is required")
    @Size(max = 100, message = "Department cannot exceed 100 characters")
    @Column(nullable = false, length = 100)
    private String department;


    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 120, message = "Age must be less than or equal to 120")
    @Column(nullable = false)
    private Integer age;
}
