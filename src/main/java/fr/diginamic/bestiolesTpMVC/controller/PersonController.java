package fr.diginamic.bestiolesTpMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.diginamic.bestiolesTpMVC.model.Animal;
import fr.diginamic.bestiolesTpMVC.model.Person;
import fr.diginamic.bestiolesTpMVC.repository.AnimalRepository;
import fr.diginamic.bestiolesTpMVC.repository.PersonRepository;
import jakarta.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("person")
    public String getPersonList(Model model) {
        List<Person> allPersons = (List<Person>) personRepository.findAll();
        model.addAttribute("persons", allPersons);
        return "list_person";
    }
    
    @GetMapping("person/{id}")
    public String getPersonbyId(@PathVariable("id") Integer id, Model model) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
            List<Animal> listAnimal = (List<Animal>) animalRepository.findAll();
            model.addAttribute("animals", listAnimal);
            return "detail_person";
        }
        
        return "erreur detectée";
    }
    
    @GetMapping("person/create")
    public String getPersonCreate(Model model) {
        model.addAttribute("person", new Person());
        List<Animal> listAnimal = (List<Animal>) animalRepository.findAll();
        model.addAttribute("animals", listAnimal);
        
        return "create_person";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer personID) {
        Optional<Person> personDelete = this.personRepository.findById(personID);
        personDelete.ifPresent(person -> this.personRepository.delete(person));
        return "redirect:/person";
    }
    
    @PostMapping("/person")
    public String createOrUpdatePerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Animal> listAnimal = (List<Animal>) animalRepository.findAll();
            model.addAttribute("animals", listAnimal);
            return "create_person";
        }
        this.personRepository.save(person);
        return "redirect:/person";
    }

}