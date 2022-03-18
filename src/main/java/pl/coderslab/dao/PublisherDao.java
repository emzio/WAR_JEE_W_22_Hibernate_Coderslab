package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher){
        entityManager.persist(publisher);
    }

    public Publisher findById(Long id){
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }

    public void delete(Publisher publisher){
//        entityManager.remove(publisher);
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }

    public Publisher findByIdWithBooks(Long id){
        Publisher publisher = findById(id);
        Hibernate.initialize(publisher.getBooks());
        return publisher;
    }

    public List<Publisher> findAll(){
        return entityManager.createQuery("select p from Publisher p").getResultList();
    }

}
