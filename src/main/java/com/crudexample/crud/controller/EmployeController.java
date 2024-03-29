package com.crudexample.crud.controller;

import com.crudexample.crud.model.Employe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeController {
    List<Employe> employes = seed();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employes", employes);
        return "index";
    }

    @GetMapping("/ajouter")
    public String ajouter(Model model){
        model.addAttribute("employe", new Employe());
        return "ajouter";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("employe") Employe employe) {
        employe.setId(employes.size() + 1);
        employes.add(employe);
        return "redirect:/";
    }

    private List<Employe> seed() {
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe(1, "Employe", "1", "Eugenie"));
        employes.add(new Employe(2, "Employe", "2", "Technician"));
        return employes;
    }


}
