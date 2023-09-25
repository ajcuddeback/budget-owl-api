package com.budgetOwl.controllers;

import com.budgetOwl.models.Users;
import com.budgetOwl.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    // TODO: These responses give WAY to much data away when an error happens, need to ensure errors are a bit more ambiguous.
    // TODO: It currently gives away SQL Data and other information attackers can use to their advantage
    @PostMapping(path="")
    public @ResponseBody Users addUser(@RequestBody Users users) {
        // TODO: Need to add middleware to this request
        // TODO: This will be fine, as users is already created in Auth Provider
        // TODO: Should already have access token, and will keep this request secure

        // TODO: ALTHOUGH, need to ensure to make a check somewhere
        // TODO: Which will check if the subscriptionId already exists
        // TODO: This will protect us from people abusing creation of users
        // TODO: If subscriptionId already exists, let them know to signin!

        // TODO: Although.. I already have unique constraint on subscriptioId, so it should throw error
        // TODO: Should test this, and see what error it throws!!
        usersRepository.save(users);
        return users;
    }

    @GetMapping(path="/id")
    public @ResponseBody Optional<Users> getUserById(@RequestParam UUID id) {
        // TODO: Add middleware to this request
        Optional<Users> foundUser = usersRepository.findById(id);
        return foundUser;
    }

    @GetMapping(path="/subscriptionId")
    public @ResponseBody Users getUserBySubscriptionId(@RequestParam(value = "subscriptionId") String subscriptionId) {
        // TODO: Add middleware to this request
        Users foundUsers = usersRepository.findBySubscriptionId(subscriptionId);
        return foundUsers;
    }

    @GetMapping(path="/fwid")
    public @ResponseBody Users getUserByFwid(@RequestParam(value = "fwid") String fwid) {
        // TODO: Add middleware to this request
        Users foundUsers = usersRepository.findByFwid(fwid);
        return foundUsers;
    }
}
