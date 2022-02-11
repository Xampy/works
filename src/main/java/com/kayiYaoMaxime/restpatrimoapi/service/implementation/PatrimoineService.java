package com.kayiYaoMaxime.restpatrimoapi.service.implementation;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import com.kayiYaoMaxime.restpatrimoapi.repository.PatrimoineRepositoryInterface;
import com.kayiYaoMaxime.restpatrimoapi.service.PatrimoineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatrimoineService implements PatrimoineServiceInterface {

    private final PatrimoineRepositoryInterface patrimoineRepository;

    @Autowired
    public PatrimoineService(PatrimoineRepositoryInterface patrimoineRepository) {
        this.patrimoineRepository = patrimoineRepository;
    }

    @Override
    public Patrimoine create(PatrimoineDto dto) {
        Patrimoine p = Patrimoine.create(dto);
        return this.patrimoineRepository.saveAndFlush(p);
    }

    @Override
    @Transactional
    public Patrimoine update(Long id, PatrimoineDto dto) {
        Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(id);
        if (patrimoineContainer.isPresent()) {
            Patrimoine patrimoine = patrimoineContainer.get();
            patrimoine.setCode(dto.getCode());
            patrimoine.setNom(dto.getNom());
            patrimoine.setEtat(dto.getEtat());
            patrimoine.setLongitude(dto.getLongitude());
            patrimoine.setLatitude(dto.getLatitude());
            patrimoine.setAdresse(dto.getAdresse());

            return patrimoine;
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(id);
            if (patrimoineContainer.isPresent()) {
                Patrimoine patrimoine = patrimoineContainer.get();
                this.patrimoineRepository.delete(patrimoine);
            }else {
                ;
            }
        } catch (Exception e){

        }
        return false;

    }

    @Override
    public List<Patrimoine> getAll() {
        return this.patrimoineRepository.findAll();
    }

    @Override
    public Patrimoine getById(Long id) {
        Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(id);
        if (patrimoineContainer.isPresent()) {
            return patrimoineContainer.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Patrimoine> getAllWithNoProprietaires() {
        return this.patrimoineRepository.getAllWithProprietairesNonConnus();
    }

    @Override
    @Transactional
    public boolean createSousPatrimoine(Long patrimoineId, Long sousPatrimoineId) {
        Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(patrimoineId);
        Optional<Patrimoine> sousPatrimoineContainer = this.patrimoineRepository.findById(sousPatrimoineId);
        if (patrimoineContainer.isPresent() && sousPatrimoineContainer.isPresent()) {
            Patrimoine parent = patrimoineContainer.get();
            parent.getSousPatrimoinesList().add(sousPatrimoineContainer.get());
            parent.setSousPatrimoinesList(parent.getSousPatrimoinesList());
            return true;
        }
        return false;
    }
}
