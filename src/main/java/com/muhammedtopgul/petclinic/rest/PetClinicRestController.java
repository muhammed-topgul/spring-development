package com.muhammedtopgul.petclinic.rest;

/*
 * created by Muhammed Topgul
 * on 07/04/2021
 * at 00:13
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.exception.OwnerNotFoundException;
import com.muhammedtopgul.petclinic.service.PetClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class PetClinicRestController {

    private final PetClinicService service;

//    @GetMapping
//    public ResponseEntity<List<OwnerEntity>> getOwners() {
//        List<OwnerEntity> owners = service.findOwners();
//        return ResponseEntity.ok(owners);
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerEntity> getOwners() throws IllegalAccessException {
        try {
            return service.findOwners();
        } catch (Exception exception) {
            throw new IllegalAccessException();
        }
    }

//    @GetMapping("/filter")
//    public ResponseEntity<List<OwnerEntity>> getOwners(@RequestParam("lastName") String lastName) {
//        List<OwnerEntity> owners = service.findOwners(lastName);
//        return ResponseEntity.ok(owners);
//    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerEntity> getOwners(@RequestParam("lastName") String lastName) throws IllegalAccessException {
        try {
            return service.findOwners(lastName);
        } catch (Exception exception) {
            throw new IllegalAccessException();
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<OwnerEntity> getOwners(@PathVariable("id") Long id) {
//        try {
//            OwnerEntity owner = service.findOwner(id);
//            return ResponseEntity.ok(owner);
//        } catch (OwnerNotFoundException exception) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception exception) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OwnerEntity getOwners(@PathVariable("id") Long id) throws IllegalAccessException {
        try {
            return service.findOwner(id);
        } catch (OwnerNotFoundException exception) {
            throw new OwnerNotFoundException(id + " cannot be found");
        } catch (Exception exception) {
            throw new IllegalAccessException();
        }
    }
}
