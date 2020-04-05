package com.acaimanager.app.business.repositories;

import com.acaimanager.app.business.models.TipoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAdicionalRepository extends JpaRepository<TipoAdicional, Long> {

    @Query("SELECT T FROM TipoAdicional T WHERE T.nome = ?1")
    TipoAdicional findByNome(String nome);
}
