package com.crudexample.crud.service;

import com.crudexample.crud.model.Employe;

import java.util.List;

public interface EmployeService{
    public void add(Employe e);
    public void modify(Employe e);
    public void delete(Employe e);
    public List<Employe> getAll();
    public Employe getOne(int id);
}
