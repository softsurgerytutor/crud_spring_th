package com.crudexample.crud.controller;

import com.crudexample.crud.model.Employe;
import com.crudexample.crud.service.Impl.EmployeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeController {

    EmployeServiceImpl employeService = new EmployeServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employes", employeService.getAll());
        return "index";
    }

    @GetMapping("/ajouter")
    public String ajouter(Model model){
        model.addAttribute("employe", new Employe());
        return "ajouter";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employe") Employe employe) {
        employeService.add(employe);
        return "redirect:/";
    }

    @GetMapping("/modifier/{id}")
    public String modifier(Model model, @PathVariable int id){
        Employe employe = employeService.getOne(id);
        model.addAttribute("employe", employe);
        return "modifier";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("employe") Employe employe){
        employeService.modify(employe);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        employeService.delete(new Employe(id));
        return "redirect:/";
    }




}
