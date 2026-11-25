package com.sneha.undergrads_management_system.service;


import com.sneha.undergrads_management_system.dto.UndergradMapper;
import com.sneha.undergrads_management_system.dto.UndergradRequestDTO;
import com.sneha.undergrads_management_system.dto.UndergradResponseDTO;
import com.sneha.undergrads_management_system.entity.Undergrad;
import com.sneha.undergrads_management_system.repository.UndergradRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//    public Undergrad createUndergrad(Undergrad undergrad){
//        return undergradRepository.save(undergrad);
//    }
    public UndergradResponseDTO createUndergrad(UndergradRequestDTO dto) {

        Undergrad undergrad = UndergradMapper.toEntity(dto);

        Undergrad savedUndergrad = undergradRepository.save(undergrad);

        return UndergradMapper.toResponseDTO(savedUndergrad);
    }

//This method:
//1. Receives an Undergrad object.
//2. Passes it to the repository.
//3. Repository saves it into the database.
//4. Returns the saved student, including the generated ID.

//    public List<Undergrad> getAllUndergrad(){
//        return undergradRepository.findAll();
//    }
public List<UndergradResponseDTO> getAllUndergrads() {

    return undergradRepository.findAll()
            .stream()
            .map(UndergradMapper::toResponseDTO)
            .toList();
}
//    public Optional<Undergrad> getUndergradById(Long id) {
//        return undergradRepository.findById(id);
//    }
public Optional<UndergradResponseDTO> getUndergradById(Long id) {

    return undergradRepository.findById(id)
            .map(UndergradMapper::toResponseDTO);
}
    //Instead of returning null, let's use Optional and return a proper HTTP 404 Not Found if the student doesn't exist.
//    public Optional<Undergrad> updateUndergrad(Long id, Undergrad updatedUndergrad) {
//
//        return undergradRepository.findById(id)
//                .map(existingUndergrad -> {
//
//                    existingUndergrad.setFirstName(updatedUndergrad.getFirstName());
//                    existingUndergrad.setLastName(updatedUndergrad.getLastName());
//                    existingUndergrad.setEmail(updatedUndergrad.getEmail());
//                    existingUndergrad.setPhoneNumber(updatedUndergrad.getPhoneNumber());
//                    existingUndergrad.setDepartment(updatedUndergrad.getDepartment());
//                    existingUndergrad.setAge(updatedUndergrad.getAge());
//
//                    return undergradRepository.save(existingUndergrad);
//                });
//    }
    public Optional<UndergradResponseDTO> updateUndergrad(
            Long id,
            UndergradRequestDTO dto) {

        return undergradRepository.findById(id)
                .map(existingUndergrad -> {

                    existingUndergrad.setFirstName(dto.getFirstName());
                    existingUndergrad.setLastName(dto.getLastName());
                    existingUndergrad.setEmail(dto.getEmail());
                    existingUndergrad.setPhoneNumber(dto.getPhoneNumber());
                    existingUndergrad.setDepartment(dto.getDepartment());
                    existingUndergrad.setAge(dto.getAge());

                    Undergrad updatedUndergrad =
                            undergradRepository.save(existingUndergrad);

                    return UndergradMapper.toResponseDTO(updatedUndergrad);
                });
    }
    public boolean deleteUndergrad(Long id) {

        if (!undergradRepository.existsById(id)) {
            return false;
        }

        undergradRepository.deleteById(id);

        return true;
    }
}
//Controller
//    ↓ UndergradRequestDTO
//Service
//    ↓ UndergradMapper.toEntity()
//Undergrad Entity
//    ↓ Repository.save()
//Database
//    ↓ Saved Entity
//Service
//    ↓ UndergradMapper.toResponseDTO()
//UndergradResponseDTO
//    ↓
//Controller
