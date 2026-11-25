package com.sneha.undergrads_management_system.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service//This class contains business logic and should be managed by the Spring container.
@RequiredArgsConstructor //This Lombok annotation generates a constructor for all final fields.
        //Conceptually, Lombok generates:
    //public UndergradService(UndergradRepository undergradRepository) {
    //this.undergradRepository = undergradRepository;
//}
public class UndergradService {
    private final UndergradRepository undergradRepository;//Our service needs the repository to interact with the database.
    //Instead of manually creating it:
    //like this UndergradRepository repository = new UndergradRepository();







}
