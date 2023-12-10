package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.AddModelDto;
import org.example.dtos.AddUserDto;
import org.example.dtos.ModelDto;
import org.example.dtos.UserDto;
import org.example.models.User;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.UserRoleService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService<UUID> userService;
    private UserRoleService userRoleService;

    @Autowired
    public void setUserService(UserService<UUID> userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserRoleService(UserRoleService<UUID> userRoleService) {
        this.userRoleService = userRoleService;
    }



    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("availableRoles", userRoleService.getAll());
        return "user-add";
    }

    @ModelAttribute("userModel")
    public AddUserDto initUser() {
        return new AddUserDto();
    }

    @PostMapping("/new")
    public String addUser(@Valid AddUserDto userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/new";
        }
        userService.register(userModel);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        model.addAttribute("userInfos", userService.getAll());
        return "user-all";
    }

    @GetMapping("/{id}")
    public String userDetails(@PathVariable("id") UUID id, Model model) {

        Optional<UserDto> u = userService.findUser(id);
        model.addAttribute("userDetails", u.orElseThrow(() ->
                new NoSuchElementException("Value not present")));

        return "user-details";
    }

    @GetMapping("delete/{id}")
    public String deleteModel(@PathVariable ("id") UUID id) {
        userService.expel(id);
        return "redirect:/users/all";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable UUID id, Model model) {
        model.addAttribute("availableRoles", userRoleService.getAll());
        Optional<UserDto> u  = userService.findUser(id);
        model.addAttribute("userModel", u.orElseThrow(() ->
                new NoSuchElementException("Value not present")));
        return "user-edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel",
                    bindingResult);
            return "redirect:/users/edit/{id}";
        }
        userService.edit(userDto);

        return "redirect:/";
    }

/*    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.register(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        return userService.findUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }*/
}
