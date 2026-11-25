package com.sneha.undergrads_management_system.controller;

import com.sneha.undergrads_management_system.dto.UndergradRequestDTO;
import com.sneha.undergrads_management_system.dto.UndergradResponseDTO;
import com.sneha.undergrads_management_system.service.UndergradService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/undergrads")
public class UndergradController {

    // Dependency Injection
    private final UndergradService undergradService;


    // CREATE undergraduate
    @PostMapping
    public ResponseEntity<UndergradResponseDTO> createUndergrad(
            @Valid @RequestBody UndergradRequestDTO dto) {

        UndergradResponseDTO createdUndergrad =
                undergradService.createUndergrad(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdUndergrad);
    }


    // GET all undergraduates
    @GetMapping
    public ResponseEntity<List<UndergradResponseDTO>> getAllUndergrads() {

        List<UndergradResponseDTO> undergrads =
                undergradService.getAllUndergrads();

        return ResponseEntity.ok(undergrads);
    }


    // GET undergraduate by ID
    @GetMapping("/{id}")
    public ResponseEntity<UndergradResponseDTO> getUndergradById(
            @PathVariable Long id) {

        return undergradService.getUndergradById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // UPDATE undergraduate
    @PutMapping("/{id}")
    public ResponseEntity<UndergradResponseDTO> updateUndergrad(
            @PathVariable Long id,
            @Valid @RequestBody UndergradRequestDTO dto) {

        return undergradService.updateUndergrad(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // DELETE undergraduate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUndergrad(
            @PathVariable Long id) {

        boolean deleted = undergradService.deleteUndergrad(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}