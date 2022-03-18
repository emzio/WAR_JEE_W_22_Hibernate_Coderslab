package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

import java.util.List;

@Controller
public class AuthorFormcontroller {
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorFormcontroller(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/form/authors")
    private String showAllAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author/list";
    }
    @GetMapping("/form/author/delete/{id}")
    private String procesDeleteForm(@PathVariable Long id){
        Author author = authorService.findById(id);
        List<Book> books = bookService.findWhereAuthor(author);
        books.stream().forEach(b -> bookService.deleteById(b.getId()));
        authorService.deleteById(id);
        return "redirect:/form/authors" ;
    }

    @GetMapping("form/author/update/{id}")
    private String showUpdateForm(Model model, @PathVariable Long id){
        model.addAttribute("author", authorService.findById(id));
        return "author/update";
    }

    @PostMapping("form/author/update")
    private String processUpdateForm(Author author){
        authorService.update(author);
        return "redirect:/form/authors";
    }

    @GetMapping("form/author/add")
    private String showAddForm(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/add";
    }

    @PostMapping("form/author/add")
    private String processAddForm(Author author){
        authorService.save(author);
        return "redirect:/form/authors";
    }
}
