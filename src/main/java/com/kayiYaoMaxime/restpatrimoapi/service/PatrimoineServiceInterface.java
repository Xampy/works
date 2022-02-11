package com.kayiYaoMaxime.restpatrimoapi.service;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;

import java.util.List;

public interface PatrimoineServiceInterface extends
        ServiceInterface<PatrimoineDto, Patrimoine, Long> {

    List<Patrimoine> getAllWithNoProprietaires();

    boolean createSousPatrimoine(Long patrimoineId, Long sousPatrimoineId);
}
