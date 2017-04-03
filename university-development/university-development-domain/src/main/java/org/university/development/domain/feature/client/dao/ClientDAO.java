package org.university.development.domain.feature.client.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.university.development.domain.feature.client.model.Client;
import org.university.development.domain.feature.commons.model.BusinessDAO;

/*
 * DOC: http://docs.spring.io/spring-data/jpa/docs/1.4.2.RELEASE/reference/html/jpa.repositories.html
 */

public interface ClientDAO extends BusinessDAO, JpaRepository<Client, String> {

    List<Client> findByName(String name, String asd);


}
