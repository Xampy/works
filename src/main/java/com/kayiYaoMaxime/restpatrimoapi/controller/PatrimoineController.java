package com.kayiYaoMaxime.restpatrimoapi.controller;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import com.kayiYaoMaxime.restpatrimoapi.service.PatrimoineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/patrimoines")
public class PatrimoineController {

    private final PatrimoineServiceInterface patrimoineService;

    @Autowired
    public PatrimoineController(PatrimoineServiceInterface patrimoineService) {
        this.patrimoineService = patrimoineService;
    }

    @PostMapping
    /**
     * Créer un paptrimoine
     */
    public ResponseEntity<PatrimoineDto> create(@RequestBody PatrimoineDto dto){
        //TODO handle errors
        Patrimoine pa = this.patrimoineService.create(dto);

        PatrimoineDto data = new PatrimoineDto(pa);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/_sousPatrimoine/{sid}")
    /**
     * Créer un sous patrimoine
     */
    public ResponseEntity<Void> createSousPatrimoine(
            @PathVariable("id") Long patrimoineId, @PathVariable("sid") Long sousPatrimoineId){

        boolean res = this.patrimoineService.createSousPatrimoine(patrimoineId, sousPatrimoineId);
        if (res == false){
            return new ResponseEntity<>((Void)null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>((Void)null, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    /**
     * Mettre à jour les données d'un patrimoine
     */
    public ResponseEntity<PatrimoineDto> update(
            @PathVariable("id") Long id, @RequestBody PatrimoineDto body){
        Patrimoine p = this.patrimoineService.update(id, body);
        if (p == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        PatrimoineDto data = new PatrimoineDto(p);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    /**
     * Récupérer patrimoine par son id
     */
    public ResponseEntity<PatrimoineDto> getById(
            @PathVariable("id") Long id){
        Patrimoine p = this.patrimoineService.getById(id);
        if (p == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        PatrimoineDto data = new PatrimoineDto(p);
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(path = "")
    /**
     * La liste de tous les patrimoines
     */
    public ResponseEntity<List<PatrimoineDto>> getAll(){
        List<Patrimoine> ps = this.patrimoineService.getAll();

        List<PatrimoineDto> data = ps.stream().map(
                (p) -> new PatrimoineDto(p)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    /**
     * Supprimer un patrimoine
     */
    public ResponseEntity<PatrimoineDto> deleteById(
            @PathVariable("id") Long id){
        boolean res = this.patrimoineService.delete(id);
        if (res == false){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);

    }




    //[START]

    @GetMapping(path = "/_no_proprietaire")
    public ResponseEntity<List<PatrimoineDto>> getAllWithNoProprietaire(){
        List<Patrimoine> ps = this.patrimoineService.getAllWithNoProprietaires();

        List<PatrimoineDto> data = ps.stream().map(
                (p) -> new PatrimoineDto(p)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(path = "/{id}/_sousPatrimoines")
    /**
     * Récuperer la liste des sous patrimoines d'un patrimoine
     */
    public ResponseEntity<List<PatrimoineDto>> getSousPatrimoine(@PathVariable("id") Long id){
        Patrimoine p = this.patrimoineService.getById(id);
        if (p == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        List<PatrimoineDto> data = p.getSousPatrimoinesList().stream().map(
                (pt) -> new PatrimoineDto(pt)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(data, HttpStatus.OK);

    }
}
