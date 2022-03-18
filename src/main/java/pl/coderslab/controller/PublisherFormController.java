package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PublisherFormController {
    private final PublisherService publisherService;
    private final BookService bookService;
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(SampleLoggerController.class);

    public PublisherFormController(PublisherService publisherService, BookService bookService) {
        this.publisherService = publisherService;
        this.bookService = bookService;
    }

    @GetMapping("/form/publishers")
    private String showAllPublishers(Model model){
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher/list";
    }

    @GetMapping("/form/publisher/add")
    private String showAddForm(Model model){
        Publisher publisher = new Publisher();
        model.addAttribute(publisher);
        return "publisher/add";
    }

    @PostMapping("/form/publisher/add")
    private String processAddForm(Publisher publisher){
        publisherService.save(publisher);
        return "redirect:/form/publishers";
    }

    @GetMapping("/form/publisher/delete/{id}")
    private String processDeleteForm(@PathVariable Long id){
//        Publisher publisher = publisherService.findByIdWithBooks(id);

        Publisher publisher = publisherService.findById(id);
//        List<Book> books = publisher.getBooks();

        List<Book> books = bookService.findWherePublisher(publisher);

        List<Book> booksToDel = new ArrayList<>();
        for (Book book : books) {
            booksToDel.add(book);
        }

//        List<Book> books = publisher.getBooks();
//        for (Book book : books) {
//            bookService.deleteById(book.getId());
////        }
//        booksToDel.stream()
//                .forEach(book -> bookService.deleteById(book.getId()));

        books.stream()
                .forEach(book -> bookService.deleteById(book.getId()));
        publisherService.deleteById(id);
        return "redirect:/form/publishers";
    }

    @GetMapping("/form/publisher/update/{id}")
    private String showUpdateForm(Model model, @PathVariable Long id){
        Publisher publisher = publisherService.findByIdWithBooks(id);
        model.addAttribute("publisher", publisher);
        model.addAttribute("books", bookService.findAll());
        return "publisher/update";
    }

    @PostMapping("/form/publisher/update")
    private String processUpdateForm(Publisher publisher){
//        for (Book book : publisher.getBooks()) {
//            book.setPublisher(publisher);
//            System.out.println("book >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + book);
////            logger.warning("book >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + book);
//            bookService.update(book);
//        }

        publisher.getBooks().stream()
                .forEach(book -> {
                    book.setPublisher(publisher);
                    bookService.update(book);
                });
        publisherService.update(publisher);
        return "redirect:/form/publishers";
    }
}
