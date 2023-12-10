package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.AddOfferDto;
import org.example.dtos.AddUserDto;
import org.example.dtos.OfferDto;
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

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private OfferService<UUID> offerService;
    private ModelService<UUID> modelService;
    private UserService<UUID> usersService;

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
        model.addAttribute("availableUsers", usersService.getAll());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public AddOfferDto initUser() {
        return new AddOfferDto();
    }

    @PostMapping("/new")
    public String addUser(@Valid AddOfferDto offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

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
    public String showAllOffers(Model model) {
        model.addAttribute("offersInfos", offerService.getAll());
        return "offer-all";
    }

/*    @PostMapping
    public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto) {
        OfferDto createdOffer = offerService.register(offerDto);
        return ResponseEntity.ok(createdOffer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        offerService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable UUID id) {
        return offerService.findOffer(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        List<OfferDto> offers = offerService.getAll();
        return ResponseEntity.ok(offers);
    }*/
}
