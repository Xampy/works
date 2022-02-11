package com.kayiYaoMaxime.restpatrimoapi.repository;

import com.kayiYaoMaxime.restpatrimoapi.enitity.Patrimoine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrimoineRepositoryInterface extends JpaRepository<Patrimoine, Long> {

    @Query("SELECT p " +
            "FROM Patrimoine p " +
            "INNER JOIN p.proprietairesList po " +
            "WHERE po = null")
    List<Patrimoine> getAllWithProprietairesNonConnus();
}
