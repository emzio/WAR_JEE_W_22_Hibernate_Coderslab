package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, PublisherService publisherService) {
        this.publisherService = publisherService;
        this.bookService = bookService;
    }

    @RequestMapping("/addNew/{title}/{rating}/{description}/{publisherName}")
    @ResponseBody
    private String addBook(@PathVariable String title,@PathVariable int rating, @PathVariable String description, @PathVariable String publisherName){

        Publisher publisher = new Publisher();
        publisher.setName(publisherName);
        publisherService.save(publisher);

        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);

        publisher.getBooks().add(book);//referencja
        bookService.save(book);

        return book.toString();
    }

    @RequestMapping("/add/{title}/{rating}/{description}/{publisherId}")
    @ResponseBody
    private String addBookPublisherId(@PathVariable String title,@PathVariable int rating, @PathVariable String description, @PathVariable Long publisherId){

        Publisher publisher = publisherService.findByIdWithBooks(publisherId);
//        Publisher publisher = publisherService.findById(publisherId);
        List<Book> books = publisher.getBooks();

        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);


        books.add(book);
        System.out.println("books>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + books);
        bookService.save(book);

        return book.toString();
    }

    @RequestMapping("/read/{id}")
    @ResponseBody
    private String read(@PathVariable Long id){
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}/{title}/{rating}/{description}")
    @ResponseBody
    private String update(@PathVariable Long id, @PathVariable String title,@PathVariable int rating, @PathVariable String description){

        Book book = bookService.findById(id);
//        book.setId(id);
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    private String delete(@PathVariable Long id){
        bookService.deleteById(id);
        return String.valueOf(id);
    }

    @GetMapping(value = "/books", params = "!rating") //bez parametru rating
    @ResponseBody
    private String findAll(){
        List<Book> books = bookService.findAll();
        return books.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }

    @GetMapping(value = "/books", params = "rating")//tylko z parametrem rating
    @ResponseBody
    private String findAllByRating(int rating){
        List<Book> books = bookService.findAllByRating(rating);
        return books.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }

    @GetMapping("/bookpublishers")
    @ResponseBody
    private String findWithPublishers(){
        return bookService.findWithPublisher().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }

    @GetMapping("/bookspublisher/{publisherId}")
    @ResponseBody
    public String findWherePublisher(@PathVariable Long publisherId){
        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        return bookService.findWherePublisher(publisher).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }

    @GetMapping("/booksauthor/{authorId}")
    @ResponseBody
    public String findWhereAuthor(@PathVariable Long authorId){
        Author author = new Author();
        author.setId(authorId);
        return bookService.findWhereAuthor(author).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }
}
