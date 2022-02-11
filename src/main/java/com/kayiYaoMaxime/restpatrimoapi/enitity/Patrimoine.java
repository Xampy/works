package com.kayiYaoMaxime.restpatrimoapi.enitity;

import com.kayiYaoMaxime.restpatrimoapi.dto.PatrimoineDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "PATRIMOINE")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patrimoine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_patrimoine", columnDefinition = "varchar(50)")
    private String code;

    @Column(name = "nom_patrimoine", columnDefinition = "varchar(100)")
    private String nom;

    @Column(name = "etat_patrimoine", columnDefinition = "varchar(20)")
    private String etat;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "adresse_patrimoine", columnDefinition = "varchar(200)")
    private String adresse;

    @OneToMany(mappedBy = "patrimoine")
    private List<Proprietaire> proprietairesList = new ArrayList<>();

    @OneToMany()
    private List<Patrimoine> sousPatrimoinesList = new ArrayList<>();


    public static Patrimoine create(PatrimoineDto dto){
        Patrimoine patrimoine = new Patrimoine();
        patrimoine.setCode(dto.getCode());
        patrimoine.setNom(dto.getNom());
        patrimoine.setEtat(dto.getEtat());
        patrimoine.setLongitude(dto.getLongitude());
        patrimoine.setLatitude(dto.getLatitude());
        patrimoine.setAdresse(dto.getAdresse());

        return patrimoine;
    }
}
