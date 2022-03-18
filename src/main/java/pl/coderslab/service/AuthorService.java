package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author){
        authorDao.save(author);
    }

    public Author findById(long id){
        return authorDao.findById(id);
    }

    public void update(Author author){
        authorDao.update(author);
    }

    public void deleteById(long id){
        authorDao.delete(authorDao.findById(id));
    }

    public List<Author> findAll(){
        return authorDao.findAll();
    }

}
