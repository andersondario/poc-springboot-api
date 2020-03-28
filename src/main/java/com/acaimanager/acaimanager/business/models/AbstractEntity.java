package com.acaimanager.acaimanager.business.models;

import javax.persistence.*;

@Entity
public abstract class AbstractEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
}
