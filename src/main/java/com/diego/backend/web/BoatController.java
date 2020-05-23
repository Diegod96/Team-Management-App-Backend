package com.diego.backend.web;


import com.diego.backend.model.Boat;
import com.diego.backend.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/board")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @PostMapping("")
    public ResponseEntity<?> addBoatToBoard(@Valid @RequestBody Boat boat, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Boat newPT = boatService.saveOrUpdateBoat(boat);
        return new ResponseEntity<Boat>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Boat> getAllBoats() {
        return boatService.findAll();
    }

    @GetMapping("/{boat_id}")
    public ResponseEntity<?> getBoatByID(@PathVariable Long boat_id) {
        Boat boat = boatService.findById(boat_id);
        return new ResponseEntity<Boat>(boat, HttpStatus.OK);
    }

    @DeleteMapping("/{boat_id}")
    public ResponseEntity<?> deleteBoat(@PathVariable Long boat_id) {
        boatService.delete(boat_id);
        return new ResponseEntity<String>("Boat was deleted", HttpStatus.OK);
    }

}
