package com.sneha.undergrads_management_system.controller;

import com.sneha.undergrads_management_system.entity.Undergrad;
import com.sneha.undergrads_management_system.service.UndergradService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor//
@RestController//Tells Spring this class handles REST requests and returns data directly in the response, typically JSON.
@RequestMapping("/api/undergrads")//Defines the common URL path for all endpoints in this controller.
public class UndergradController {
    //dependency injection
    private final UndergradService undergradService;
    @PostMapping
    public Undergrad createUndergrad(@RequestBody Undergrad undergrad){
        return undergradService.createUndergrad(undergrad);
    }
    @GetMapping
    public List<Undergrad> getAllUndergrad(){
        return undergradService.getAllUndergrad();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Undergrad> getUndergradById(@PathVariable Long id) {

        return undergradService.getUndergradById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
