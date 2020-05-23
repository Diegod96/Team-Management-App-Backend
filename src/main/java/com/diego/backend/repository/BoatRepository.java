package com.diego.backend.repository;

import com.diego.backend.model.Boat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends CrudRepository<Boat, Long> {

    Boat getById(Long id);

}
