package org.workshop.aiconferencebooking.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.workshop.aiconferencebooking.model.Talk;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SearchRepository {

    private final EntityManager em;
    private final DataSource dataSource;

    public SearchRepository(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }

    public List<Talk> searchTalk(String input) {
        // lowercase the input
        var lowerInput = input.toLowerCase();
        // create a native query using named parameters
        // to search for talks
        // joined with the person table
        // with the input in the
        // description, title or speaker username
        // format the code to make it more readable
        var query = em.createNativeQuery(
            "select t.* from Talk t join Person p on t.speaker_id = p.id " +
            "where lower(t.description) like :input " +
            "OR lower(t.title) like :input " +
            "OR lower(p.username) like :input", Talk.class
        );
        // set the input parameter
        query.setParameter("input", "%" + lowerInput + "%");
        // get the result list
        var talks = (List<Talk>) query.getResultList();
        // return the list of talks
        return talks;
    }
}
