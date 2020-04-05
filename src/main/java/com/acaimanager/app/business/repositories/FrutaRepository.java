package com.acaimanager.app.business.repositories;

import com.acaimanager.app.business.models.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta, Long> {

    @Query("SELECT T FROM Fruta T WHERE T.nome = ?1")
    Fruta findByNome(String nome);
}
