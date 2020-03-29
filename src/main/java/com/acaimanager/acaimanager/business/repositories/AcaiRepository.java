package com.acaimanager.acaimanager.business.repositories;

import com.acaimanager.acaimanager.business.models.Acai;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class AcaiRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Acai create(Acai acai) {
        return (Acai) sessionFactory.getCurrentSession().save(acai);
    }

    @SuppressWarnings("unchecked")
    public List<Acai> findAll() {
        final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Acai.class);
        return criteria.list();
    }
}
