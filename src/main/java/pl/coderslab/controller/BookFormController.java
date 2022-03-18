package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.Collection;
import java.util.List;

@Controller
class BookFormController {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public BookFormController(PublisherService publisherService, AuthorService authorService, BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping(path = "/form/book")
    String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping(path = "/form/book")
    String processAddForm(Book book) {
        bookService.save(book);
        return "redirect:/form/books";
    }

    @GetMapping(path = "/form/books")
    String showAllBooks(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/form/update/{id}")
    private String showUpdateForm(Model model, @PathVariable Long id){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/update";
    }

    @PostMapping("/form/update/{id}")

    private String processUpdateForm(Book book){
        bookService.update(book);
        return "redirect:/form/books";
    }

    @GetMapping("/form/delete/{id}")
    private String showDeleteForm(Model model, @PathVariable Long id){
        model.addAttribute(bookService.findById(id));
        return "book/delete";
    }

//    @PostMapping("/form/delete/{id}")
    @PostMapping("/form/delete")
    private String processDeleteForm(Book book){
        bookService.deleteById(book.getId());
        return "redirect:/form/books";
    }

    @ModelAttribute("authors")
    Collection<Author> findAllAuthors() {
        return authorService.findAll();
    }

    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        return publisherService.findAll();
    }
}