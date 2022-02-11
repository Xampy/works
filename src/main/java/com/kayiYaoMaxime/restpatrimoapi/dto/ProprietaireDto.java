package com.kayiYaoMaxime.restpatrimoapi.dto;

import com.kayiYaoMaxime.restpatrimoapi.enitity.Proprietaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProprietaireDto {
    private Long id;
    private String nom;
    private String telephone;
    private String adresse;
    private String email;

    public ProprietaireDto(Proprietaire p) {

        this.id = p.getId();
        this.nom = p.getNom();
        this.telephone = p.getTelephone();
        this.adresse = p.getAdresse();
        this.email = p.getEmail();
    }
}
