package com.company.controllers;

import com.company.entities.Drug;
import com.company.repositories.interfaces.IDrugRepositories;

import java.util.List;
import java.text.SimpleDateFormat;

public class DrugController {
    private final IDrugRepositories repo;

    public DrugController(IDrugRepositories repo){this.repo=repo;}

    public String getDrugByDestination(String cur){
        List <Drug> drugs = repo.getDrugByDestination(cur);
        return drugs.toString();
    }

    public String getDrugByTimeToUse(int cur){
        List <Drug> drugs = repo.getDrugByTimeToUse(cur);
        return drugs.toString();
    }

    public String deleteDrug(int id){
        Drug drug = repo.getDrug(id);
        boolean created = repo.deleteDrug(drug);
        return (created ? "Drug was deleted!" : "Drug deletion was failed! ");
    }

    public String createDrug(int id, String name, int price, String expirationdate, String manufacturer, String destination, int timeToUse){
        Drug drug = new Drug(id, name, price, expirationdate, manufacturer, destination, timeToUse);
        boolean created = repo.createDrug(drug);
        return (created ? "Drug was created!" : "Drug creation was failed! ");
    }
    public  String getDrug(int id){
        Drug drug = repo.getDrug(id);

        return (drug == null ? "Drug was not found!" : drug.toString());
    }

    public  String getDrugByName(String name){
        Drug drug = repo.getDrugByName(name);

        return (drug == null ? "Drug was not found!" : drug.toString());
    }

    public String getAllDrugs(){
        List <Drug> drugs = repo.getAllDrugs();

        return drugs.toString();
    }
}
