package com.muhammedtopgul.petclinic.rest;

/*
 * created by Muhammed Topgul
 * on 07/04/2021
 * at 00:13
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.exception.InternalServerException;
import com.muhammedtopgul.petclinic.exception.OwnerNotFoundException;
import com.muhammedtopgul.petclinic.service.PetClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class PetClinicRestController {

    private final PetClinicService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public URI createOwner(@RequestBody OwnerEntity entity) {
        try {
            service.createOwner(entity);
            Long id = entity.getId();
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
            return uri;
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OwnerEntity updateOwner(@PathVariable("id") Long id, @RequestBody OwnerEntity entity) {
        try {
            OwnerEntity ownerFromDb = service.findOwner(id);
            ownerFromDb.setFirstName(entity.getFirstName());
            ownerFromDb.setLastName(entity.getLastName());
            service.updateOwner(entity);
            return ownerFromDb;
        } catch (OwnerNotFoundException exception) {
            throw new OwnerNotFoundException(id + " cannot be found.");
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOwner(@PathVariable("id") Long id) {
        try {
            service.deleteOwner(id);
            return "Owner deleted.";
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerEntity> getOwners() {
        try {
            return service.findOwners();
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerEntity> getOwners(@RequestParam("lastName") String lastName) {
        try {
            return service.findOwners(lastName);
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OwnerEntity getOwners(@PathVariable("id") Long id) {
        try {
            return service.findOwner(id);
        } catch (OwnerNotFoundException exception) {
            throw new OwnerNotFoundException(id + " cannot be found");
        } catch (Exception exception) {
            throw new InternalServerException();
        }
    }
}
