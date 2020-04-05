package com.acaimanager.app.business.repositories;

import com.acaimanager.app.business.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {

    @Query("SELECT T FROM Tamanho T WHERE T.nome = ?1")
    Tamanho findByNome(String nome);
}
