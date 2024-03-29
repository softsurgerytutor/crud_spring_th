package com.crudexample.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private String fonction;
}
