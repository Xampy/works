package com.kayiYaoMaxime.restpatrimoapi.service;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import com.kayiYaoMaxime.restpatrimoapi.dto.ProprietaireDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Proprietaire;

public interface ProprietaireServiceInterface extends
        ServiceInterface<ProprietaireDto, Proprietaire, Long>{

    boolean addPatrimoine(Long proprietaireId, Long patrimoineId);
    boolean removePatrimoine(Long proprietaireId, Long patrimoineId);

}
