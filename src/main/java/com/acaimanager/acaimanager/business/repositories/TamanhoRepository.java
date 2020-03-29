package com.acaimanager.acaimanager.business.repositories;

import com.acaimanager.acaimanager.business.models.Fruta;
import com.acaimanager.acaimanager.business.models.Tamanho;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
public class TamanhoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Tamanho findByNome(String nome) {
        return (Tamanho) sessionFactory.getCurrentSession()
                .createCriteria(Tamanho.class)
                .add(eq("nome", nome))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Tamanho> findAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Tamanho.class)
                .list();
    }
}
