package com.kayiYaoMaxime.restpatrimoapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kayiYaoMaxime.restpatrimoapi.dto.ProprietaireDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Proprietaire;
import com.kayiYaoMaxime.restpatrimoapi.service.ProprietaireServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/proprietaires")
public class ProprietaireController {

    private final ProprietaireServiceInterface proprietaireService;


    @Autowired
    public ProprietaireController(ProprietaireServiceInterface proprietaireService) {
        this.proprietaireService = proprietaireService;
    }


    @PostMapping
    /**
     * Créer un proprietaire
     */
    public ResponseEntity<ProprietaireDto> create(@RequestBody ProprietaireDto body){
        Proprietaire p = this.proprietaireService.create(body);

        ProprietaireDto data = new ProprietaireDto(p);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @PutMapping(path = "/{id}")
    /**
     * Mettre à jour un proprietaire
     */
    public ResponseEntity<ProprietaireDto> update(
            @PathVariable("id") Long id, @RequestBody ProprietaireDto body){
        Proprietaire p = this.proprietaireService.update(id, body);
        if (p == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        ProprietaireDto data = new ProprietaireDto(p);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    /**
     * Récupérer un proprieetire
     */
    public ResponseEntity<ProprietaireDto> getById(
            @PathVariable("id") Long id){
        Proprietaire p = this.proprietaireService.getById(id);
        if (p == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        ProprietaireDto data = new ProprietaireDto(p);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(path = "")
    /**
     * Récupérer tous les proprietaires
     */
    public ResponseEntity<List<ProprietaireDto>> getAll(){
        List<Proprietaire> ps = this.proprietaireService.getAll();

        List<ProprietaireDto> data = ps.stream().map(
                (p) -> new ProprietaireDto(p)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    /**
     * Supprimer un proprietaire
     */
    public ResponseEntity<ProprietaireDto> deleteById(
            @PathVariable("id") Long id){
        boolean res = this.proprietaireService.delete(id);
        if (res == false){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    //[START] Patrimoine
    @PostMapping("/{proprietaireId}/patrimoine/{patrimoineId}")
    /**
     * Enregistrer un patrimoine pour un proprietaire
     */
    public ResponseEntity<Void> addPatrimoine(
            @PathVariable("proprietaireId") Long proprietaireId,
            @PathVariable("patrimoineId") Long patrimoineId){

        boolean res = this.proprietaireService.addPatrimoine(proprietaireId, patrimoineId);
        if (res == true){
            return new ResponseEntity<>((Void) null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>((Void) null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{proprietaireId}/patrimoine/{patrimoineId}")
    /**
     * Suprrimer un patrimoine pour un proprietaire
     */
    public ResponseEntity<Void> removePatrimoine(
            @PathVariable("proprietaireId") Long proprietaireId,
            @PathVariable("patrimoineId") Long patrimoineId){

        boolean res = this.proprietaireService.removePatrimoine(proprietaireId, patrimoineId);
        if (res == true){
            return new ResponseEntity<>((Void) null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>((Void) null, HttpStatus.NOT_FOUND);
        }

    }
    //[END] Patrimoine


}
