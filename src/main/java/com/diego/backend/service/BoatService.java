package com.diego.backend.service;

import com.diego.backend.model.Boat;
import com.diego.backend.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Boat saveOrUpdateBoat(Boat boat) {

        if (boat.getStatus() == null || boat.getStatus() == "") {
            boat.setStatus("Low");
        }

        return boatRepository.save(boat);
    }

    public Iterable<Boat> findAll() {
        return boatRepository.findAll();
    }

    public Boat findById(Long id) {
        return boatRepository.getById(id);
    }

    public void delete(Long id) {
        Boat boat = findById(id);
        boatRepository.delete(boat);
    }
}
