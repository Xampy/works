package com.kayiYaoMaxime.restpatrimoapi.repository;

import com.kayiYaoMaxime.restpatrimoapi.enitity.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepositoryInterface extends JpaRepository<Proprietaire, Long> {
}
