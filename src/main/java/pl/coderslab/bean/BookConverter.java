package pl.coderslab.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

public class BookConverter implements Converter<String, Book> {

    @Autowired
    private BookService bookService;


    @Override
    public Book convert(String source) {
        return bookService.findById(Long.parseLong(source));
    }
}
