package com.acaimanager.acaimanager.business.repositories;

import com.acaimanager.acaimanager.business.models.Adicional;
import com.acaimanager.acaimanager.business.models.Fruta;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
public class AdicionaisRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Adicional findBy(String nome) {
        return (Adicional) sessionFactory.getCurrentSession()
                .createCriteria(Adicional.class)
                .add(eq("nome", nome))
                .uniqueResult();
    }
}
