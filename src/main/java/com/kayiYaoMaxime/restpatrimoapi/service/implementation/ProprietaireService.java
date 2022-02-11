package com.kayiYaoMaxime.restpatrimoapi.service.implementation;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import com.kayiYaoMaxime.restpatrimoapi.dto.ProprietaireDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Proprietaire;
import com.kayiYaoMaxime.restpatrimoapi.repository.PatrimoineRepositoryInterface;
import com.kayiYaoMaxime.restpatrimoapi.repository.ProprietaireRepositoryInterface;
import com.kayiYaoMaxime.restpatrimoapi.service.ProprietaireServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireService implements ProprietaireServiceInterface {

    private final ProprietaireRepositoryInterface proprietaireRepository;
    private final PatrimoineRepositoryInterface patrimoineRepository;

    @Autowired
    public ProprietaireService(ProprietaireRepositoryInterface proprietaireRepository,
                               PatrimoineRepositoryInterface patrimoineRepository) {
        this.proprietaireRepository = proprietaireRepository;
        this.patrimoineRepository = patrimoineRepository;
    }

    @Override
    public Proprietaire create(ProprietaireDto dto) {
        Proprietaire proprio = new Proprietaire();

        proprio.setAdresse(dto.getAdresse());
        proprio.setNom(dto.getNom());
        proprio.setTelephone(dto.getTelephone());
        proprio.setEmail(dto.getEmail());

        return this.proprietaireRepository.saveAndFlush(proprio);
    }

    @Override
    @Transactional
    /**
     * Update a proprietaire. If the no proprietaire found by id
     * return null else return the updated proprietaire
     */
    public Proprietaire update(Long id, ProprietaireDto dto) {
        Optional<Proprietaire> proprioContainer = this.proprietaireRepository.findById(id);
        if (proprioContainer.isPresent()){
            Proprietaire proprio = proprioContainer.get();

            proprio.setAdresse(dto.getAdresse());
            proprio.setNom(dto.getNom());
            proprio.setTelephone(dto.getTelephone());
            proprio.setEmail(dto.getEmail());

            return proprio;
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Optional<Proprietaire> proprioContainer = this.proprietaireRepository.findById(id);
            if (proprioContainer.isPresent()){
                Proprietaire proprio = proprioContainer.get();
                this.proprietaireRepository.delete(proprio);
            }else {
               throw new Exception("");
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Proprietaire> getAll() {
        return this.proprietaireRepository.findAll();
    }

    @Override
    public Proprietaire getById(Long id) {
        Optional<Proprietaire> proprioContainer = this.proprietaireRepository.findById(id);
        if (proprioContainer.isPresent()){
            return proprioContainer.get();
        }else {
            return null;
        }
    }


    @Transactional
    public boolean addPatrimoine(Long proprietaireId, Long patrimoineId){
        Optional<Proprietaire> proprietaireContainer = this.proprietaireRepository.findById(proprietaireId);
        Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(patrimoineId);

        if (proprietaireContainer.isPresent() && patrimoineContainer.isPresent()){
            Patrimoine patrimoine = patrimoineContainer.get();
            patrimoine.getProprietairesList()
                    .add(proprietaireContainer.get());
            patrimoine.setProprietairesList(
                    patrimoine.getProprietairesList()
            );
            return true;
        }
        return false;
    }

    @Transactional
    public boolean removePatrimoine(Long proprietaireId, Long patrimoineId){
        Optional<Proprietaire> proprietaireContainer = this.proprietaireRepository.findById(proprietaireId);
        Optional<Patrimoine> patrimoineContainer = this.patrimoineRepository.findById(patrimoineId);

        if (proprietaireContainer.isPresent() && patrimoineContainer.isPresent()){
            patrimoineContainer.get().getProprietairesList().remove(proprietaireContainer.get());
            return true;
        }
        return false;
    }
}
