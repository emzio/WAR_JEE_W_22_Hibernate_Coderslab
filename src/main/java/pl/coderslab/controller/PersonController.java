package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;

@Controller
class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/form/person")
    String showForm(Model model) {
        Person person = new Person();
        person.setLogin("Ala ma kota");
        person.setEmail("email@email.pl");
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping(path = "/form/person")
    @ResponseBody
    String addPerson(Person person
            ) {
        personService.save(person);

        return person.toString();
    }

//    @PostMapping(path = "/form/person")
//    @ResponseBody
//    String addPerson(
//            @RequestParam String login,
//            @RequestParam String password,
//            @RequestParam String email) {
//
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//
//        personService.save(person);
//
//        return person.toString();
//    }
}