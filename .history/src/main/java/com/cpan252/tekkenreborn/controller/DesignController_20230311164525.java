package com.cpan252.tekkenreborn.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.repository.FighterRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {

    /**
     * In java you should use the interface instead of the concrete class.
     * It helps you to switch implementations without having to change the code.
     */
    @Autowired
    private FighterRepository fighterRepository;

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class);
        model.addAttribute("animes", animes);
        log.info("animes converted to string:  {}", animes);
    }

    /**
     * 1. We have created a new Fighter object here, to be populated from the form
     * inputs
     * 2. We have to reference the Fighter object properties in the form and bind
     * them to the corresponding inputs
     * 3. We have to submit Form (execute POST request) and make sure fighter
     * details are valid
     * 
     * @return Fighter model that we will need only for request (form) submission
     */
    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Fighter fighter() {
        return Fighter
                .builder()
                .build();
    }

    @PostMapping
    public String processFighterAddition(@Valid Fighter fighter, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }
        log.info("Processing fighter: {}", fighter);
        fighterRepository.save(fighter);
        return "redirect:/fighterlist";
    }

}
