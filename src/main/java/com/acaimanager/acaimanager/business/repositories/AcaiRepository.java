package com.acaimanager.acaimanager.business.repositories;

import com.acaimanager.acaimanager.business.models.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaiRepository extends JpaRepository<Acai, Long> {

}
