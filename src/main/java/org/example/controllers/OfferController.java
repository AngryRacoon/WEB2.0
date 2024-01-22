package org.example.controllers;

import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dtos.*;
import org.example.models.Offer;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private OfferService<UUID> offerService;
    private ModelService<UUID> modelService;
    private UserService<UUID> usersService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public void setOfferService(OfferService<UUID> offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setModelService(ModelService<UUID> modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setUsersService(UserService<UUID> usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/new")
    public String addOffer(Model model) {
        model.addAttribute("availableModels", modelService.getAll());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public AddOfferDto initUser() {
        return new AddOfferDto();
    }

    @PostMapping("/new")
    public String addOffer(@Valid AddOfferDto offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,Principal principal) {
        LOG.log(Level.INFO, "add offer by " + principal.getName());
        offerModel.setUser(principal.getName());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/new";
        }
        offerService.register(offerModel);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllOffers(@RequestParam(value = "sort", required = false) String param, Principal principal, Model model) {
        if (principal != null)
            LOG.log(Level.INFO, "show all offers for " + principal.getName() + "with sort param " + param);
        else
            LOG.log(Level.INFO, "show all offers for " + "Guest" + "with sort param " + param);
        List<LightOfferDto> o = offerService.getAll();
        if (param != null) {
            switch (param) {
                case "priceasc":
                    o.sort(Comparator.comparing(LightOfferDto::getPrice));
                    break;
                case "pricedesc":
                    o.sort(Comparator.comparing(LightOfferDto::getPrice).reversed());
                    break;
                case "yearolder":
                    o.sort(Comparator.comparing(LightOfferDto::getYear));
                    break;
                case "yearnewer":
                    o.sort(Comparator.comparing(LightOfferDto::getYear).reversed());
                    break;
            }
        }
        model.addAttribute("offersInfos", o);
        return "offer-all";
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") UUID id, Model model) {
        Optional<OfferDto> o = offerService.findOffer(id);
        model.addAttribute("offerDetails", o.orElseThrow(() ->
                new NoSuchElementException("Value not present")));

        return "offer-details";
    }

    @GetMapping("delete/{id}")
    public String deleteOffer(Principal principal,@PathVariable("id") UUID id) {
        LOG.log(Level.INFO, "delete offer by " + principal.getName());
        offerService.expel(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/edit/{id}")
    public String editOffer(@PathVariable UUID id, Model model) {
        model.addAttribute("availableModels", modelService.getAll());
        model.addAttribute("availableUsers", usersService.getAll());
        Optional<OfferDto> u  = offerService.findOffer(id);
        model.addAttribute("offerModel", u.orElseThrow(() ->
                new NoSuchElementException("Value not present")));
        return "offer-edit";
    }

    @PostMapping("/edit/{id}")
    public String editOffer(@Valid EditOfferDto offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/edit/{id}";
        }
        offerService.edit(offerDto);

        return "redirect:/";
    }

}
