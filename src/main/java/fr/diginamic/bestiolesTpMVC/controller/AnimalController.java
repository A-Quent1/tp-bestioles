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
import fr.diginamic.bestiolesTpMVC.model.Species;
import fr.diginamic.bestiolesTpMVC.repository.AnimalRepository;
import fr.diginamic.bestiolesTpMVC.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
public class AnimalController {
	
    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private SpeciesRepository speciesRepository;
    
    @GetMapping("animal")
    public String getAnimalList(Model model) {
        List<Animal> allAnimals = (List<Animal>) animalRepository.findAll();
        model.addAttribute("animals", allAnimals);
        return "list_animals";
    }
    
    @GetMapping("animal/{id}")
    public String getAnimalbyId(@PathVariable("id") Integer id, Model model) {
        Optional<Animal> animal = animalRepository.findById(id);
        if(animal.isPresent()) {
        	model.addAttribute("animal", animal.get());
        	List<Species> listSpecies = (List<Species>) speciesRepository.findAll();
        	model.addAttribute("species", listSpecies);
        	return "detail_animal";
        }
        
        return "erreur detectée";
    }
    
    @GetMapping("animal/create")
    public String getAnimalCreate(Model model) {
        model.addAttribute("animal", new Animal());
        List<Species> listSpecies = (List<Species>) speciesRepository.findAll();
        model.addAttribute("listSpecies", listSpecies);
        return "create_animal";
    }
    
    @GetMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer animalId) {
    	Optional<Animal> animalDelete = this.animalRepository.findById(animalId);
    	animalDelete.ifPresent(animal -> this.animalRepository.delete(animal));
    	return "redirect:/animal";
    }

    @PostMapping("/animal")
    public String createOrUpdateAnimal(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Species> listSpecies = (List<Species>) speciesRepository.findAll();
            model.addAttribute("listSpecies", listSpecies);
            return "create_animal";
        }
        this.animalRepository.save(animal);
        return "redirect:/animal";
    }
}