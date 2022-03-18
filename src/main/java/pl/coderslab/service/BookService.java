package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;


@Service
@Transactional //org.spring...
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book){
        bookDao.save(book);
    }

    public Book findById(Long id){
        return bookDao.finById(id);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void deleteById(Long id){
//        Book book =bookDao.finById(id);
//        bookDao.delete(book);
        bookDao.delete(bookDao.finById(id));
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public List<Book>  findAllByRating(int rating){
        return bookDao.findAllByRating(rating);
    }

    public List<Book> findWithPublisher(){
        return bookDao.findWithPublisher();
    }

    public List<Book> findWherePublisher(Publisher publisher){
        return bookDao.findWherePublisher(publisher);
    }

    public List<Book> findWhereAuthor(Author author){
        return bookDao.findWhereAuthor(author);
    }
}
