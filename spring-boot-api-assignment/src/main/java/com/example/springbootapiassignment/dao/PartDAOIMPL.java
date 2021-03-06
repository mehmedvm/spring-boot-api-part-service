package com.example.springbootapiassignment.dao;
//IMPORTANT If your code is not working your imports might be incorrect

import com.example.springbootapiassignment.entity.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PartDAOIMPL implements PartDAO{

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public PartDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Part> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Part> myQuery = currentSession.createQuery("from Part");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Part findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Part.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Part thePart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePart);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part myPart = currentSession.get(Part.class, theId);
        currentSession.delete(myPart);
    }

}
