package com.kayiYaoMaxime.restpatrimoapi.dto;

import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatrimoineDto {
    private Long id;
    private String code;
    private String nom;
    private String etat;
    private Float longitude;
    private Float latitude;
    private String adresse;

    private List<ProprietaireDto> proprietaires = new ArrayList<>();
    private List<PatrimoineDto> sousPatrimoines = new ArrayList<>();

    public PatrimoineDto(Patrimoine pa) {
        this.id = pa.getId();
        this.code = pa.getCode();
        this.nom = pa.getNom();
        this.etat = pa.getEtat();
        this.longitude = pa.getLongitude();
        this.latitude = pa.getLatitude();
        this.adresse = pa.getAdresse();

        if (pa.getProprietairesList() != null){
            this.setProprietaires(
                    pa.getProprietairesList().stream().map(
                            p -> new ProprietaireDto(p)
                    ).collect(Collectors.toList())
            );
        }

        if (pa.getSousPatrimoinesList() != null){
            this.setSousPatrimoines(
                    pa.getSousPatrimoinesList().stream().map(
                            p -> new PatrimoineDto(pa)
                    ).collect(Collectors.toList())
            );
        }
    }
}
