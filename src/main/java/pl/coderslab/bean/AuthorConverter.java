package pl.coderslab.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;


public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String source) {
        return authorService.findById(Long.parseLong(source));
    }
}
