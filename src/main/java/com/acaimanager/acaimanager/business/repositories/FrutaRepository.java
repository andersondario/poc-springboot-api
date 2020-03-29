package com.acaimanager.acaimanager.business.repositories;

import com.acaimanager.acaimanager.business.models.Fruta;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
public class FrutaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Fruta findByNome(String nome) {
        return (Fruta) sessionFactory.getCurrentSession()
                .createCriteria(Fruta.class)
                .add(eq("nome", nome))
                .uniqueResult();
    }
}
