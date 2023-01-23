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

import fr.diginamic.bestiolesTpMVC.model.Species;
import fr.diginamic.bestiolesTpMVC.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
public class SpeciesController {
	
    @Autowired
    private SpeciesRepository speciesRepository;
    
    @GetMapping("specie")
    public String getSpeciesList(Model model) {
        List<Species> allSpecies = (List<Species>) speciesRepository.findAll();
        model.addAttribute("species", allSpecies);
        return "list_species";
    }
    
    @GetMapping("specie/{id}")
    public String getSpeciesbyId(@PathVariable("id") Integer id, Model model) {
        Optional<Species> species = speciesRepository.findById(id);
        if(species.isPresent()) {
        	model.addAttribute("species", species.get());
        	return "detail_species";
        }
        
        return "erreur detectée";
    }
    
    @GetMapping("specie/create")
    public String getSpeciesCreate(Model model) {
        model.addAttribute("species", new Species());
        return "create_specie";
    }
    
    @GetMapping("/specie/delete/{id}")
    public String deleteSpecies(@PathVariable("id") Integer specieID) {
    	Optional<Species> speciesToDelete = this.speciesRepository.findById(specieID);
    	speciesToDelete.ifPresent(specie -> this.speciesRepository.delete(specie));
    	return "redirect:/specie";
    }
    
    @PostMapping("/specie")
    public String createOrUpdateSpecies(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return "create_specie";
        }
    this.speciesRepository.save(species);
    return "redirect:/specie";
    }
}