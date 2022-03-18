package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/publisher/add/{name}")
    @ResponseBody
    private String addPublisher(@PathVariable String name){
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherService.save(publisher);
        return publisher.toString();
    }

    @RequestMapping("publisher/read/{id}")
    @ResponseBody
    private String read(@PathVariable Long id){
//        Publisher publisher = publisherService.findById(id);
        Publisher publisher = publisherService.findByIdWithBooks(id);
        return publisher.toString();
    }

    @RequestMapping("publisher/update/{id}/{name}")
    @ResponseBody
    private String update(@PathVariable Long id, @PathVariable String name){
        Publisher publisher = publisherService.findById(id);
        publisher.setName(name);
        publisherService.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    private String delete(@PathVariable Long id){
        publisherService.deleteById(id);
        return String.valueOf(id);
    }

    @RequestMapping("/publishers")
    @ResponseBody
    private String findAll(){
        return publisherService.findAll().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" | "));
    }
}
