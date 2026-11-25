package com.sneha.undergrads_management_system.repository;

import com.sneha.undergrads_management_system.entity.Undergrad;
import org.springframework.data.jpa.repository.JpaRepository;


//An interface defines what operations are available, without us implementing all the logic ourselves.
public interface UndergradRepository extends JpaRepository<Undergrad,Long> {
    //Create database operations for my Undergrad entity, whose primary key type is Long.
    //JpaRepository<EntityType, PrimaryKeyType>

}
