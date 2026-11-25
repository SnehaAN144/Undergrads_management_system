package com.sneha.undergrads_management_system.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity  //This Java class represents a database entity that should be mapped to a database table.
@Table(name="undergrads")
@Getter//Generates getter methods
@Setter//Generates setter methods
@NoArgsConstructor//Generates a constructor with no arguments
public class Undergrad {
    @Id//uniquely determines each record
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tells db to generate id automatically
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    @Column(name = "academic_year")
    private Integer year;
}
