package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/author/add/{name}/{lastName}")
    @ResponseBody
    public String addAuthor(@PathVariable String name, @PathVariable String lastName){



        Author author = new Author();
        author.setFirstName(name);
        author.setLastName(lastName);
        authorService.save(author);
        return author.toString();
    }

    @RequestMapping("/author/{id}")
    @ResponseBody
    public String findById(@PathVariable long id){
        return authorService.findById(id).toString();
    }

    @RequestMapping("/author/update/{id}/{name}/{lastName}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String name, @PathVariable String lastName){
        Author author = authorService.findById(id);
        author.setFirstName(name);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    private String delete(@PathVariable Long id){
            authorService.deleteById(id);
            return String.valueOf(id);
    }

    @GetMapping("/authors")
    @ResponseBody
    private String findAll(){
        return authorService.findAll()
                .stream().map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }

}
