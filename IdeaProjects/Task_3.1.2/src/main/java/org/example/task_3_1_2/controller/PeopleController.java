package org.example.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeopleController {

    private final UserService userService;


    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String print(ModelMap model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping(value = "/users")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping(value ="/new")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

}