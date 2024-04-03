package com.crudexample.crud.service.Impl;

import com.crudexample.crud.model.Employe;
import com.crudexample.crud.service.EmployeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeServiceImpl implements EmployeService {

    List<Employe> employes;

    public EmployeServiceImpl(){
        employes = new ArrayList<>();
        seed();
    }

    @Override
    public void add(Employe e) {
        e.setId(this.getMaxId() + 1);
        employes.add(e);
    }

    @Override
    public void modify(Employe e) {
        int index = employes.indexOf(e);
        employes.remove(index);
        employes.add(index,e);
    }

    @Override
    public void delete(Employe e) {
        List<Employe> opt = employes.stream()
                .filter(employe -> employe.getId() != e.getId())
                .toList();
        employes.clear();
        employes.addAll(opt);
    }

    @Override
    public List<Employe> getAll() {
        return employes;
    }

    @Override
    public Employe getOne(int id) {
        Optional<Employe> opt = employes.stream()
                .filter(employe -> employe.getId() == id)
                .findFirst();
        return opt.orElse(null);
    }

    public int getMaxId(){
        Optional<Employe> opt = employes.stream().max((e1, e2) -> e1.getId() - e2.getId());
        if (opt.isPresent()) return opt.get().getId();
        else return -1;
    }

    private void seed() {
        employes.add(new Employe(1, "Employe", "1", "Eugenie"));
        employes.add(new Employe(2, "Employe", "2", "Technician"));
    }
}
