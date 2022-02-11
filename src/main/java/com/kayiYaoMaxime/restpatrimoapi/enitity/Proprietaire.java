package com.kayiYaoMaxime.restpatrimoapi.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "PROPRIETAIRE")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_proprietaire", columnDefinition = "varchar(200)")
    private String nom;

    @Column(name = "tel_proprietaire", columnDefinition = "varchar(20)")
    private String telephone;

    @Column(name = "adr_proprietaire", columnDefinition = "varchar(200)")
    private String adresse;

    @Column(name = "email_proprietaire", columnDefinition = "varchar(50)")
    private String email;

    @ManyToOne
    private Patrimoine patrimoine;
}
