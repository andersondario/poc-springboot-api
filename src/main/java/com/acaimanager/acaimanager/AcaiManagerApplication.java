package com.acaimanager.acaimanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class AcaiManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcaiManagerApplication.class, args);
	}
}
