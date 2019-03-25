package com.nc.memory.controller;

import com.nc.memory.domain.Client;
import com.nc.memory.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    // Это означает, что бин называется userRepository
    // Который автоматически генерируется Spring, мы будем использовать его для обработки данных
    private ClientRepository clientRepository;

    @GetMapping
    public String main(Model model) {
        Iterable<Client> clients = clientRepository.findAll();

        model.addAttribute("clients", clients);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Client client = new Client(firstName, lastName);

        clientRepository.save(client);

        Iterable<Client> clients = clientRepository.findAll();

        model.addAttribute("clients", clients);

        return "main";
    }
}
