package com.acaimanager.app.business.repositories;

import com.acaimanager.app.business.models.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaiRepository extends JpaRepository<Acai, Long> {

}
