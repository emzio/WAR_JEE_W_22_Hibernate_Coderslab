package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book finById(Long id){
        return entityManager.find(Book.class, id);
    }

    public void update(Book book){
        entityManager.merge(book);
    }

    public void delete(Book book){
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List books = query.getResultList();
        return books;
    }

    public List<Book>  findAllByRating(int rating){
        return entityManager.createQuery("select b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findWithPublisher(){
//        entityManager.createQuery("select b from Book b where b.publisher is not null");//zamiast innerJoin
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher");
        return query.getResultList();
    }

    public List<Book> findWherePublisher(Publisher publisher){
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher=:publisher");
        query.setParameter("publisher",publisher);
        return query.getResultList();
    }

    public List<Book> findWhereAuthor(Author author){
        Query query = entityManager.createQuery("SELECT b FROM Book b where :author member of b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
//"WHERE :author member of b.authors"
//"SELECT b FROM Book b where b.authors=:author"