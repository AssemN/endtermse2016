package com.company.repositories.interfaces;

import com.company.entities.Drug;

import java.util.List;
import java.text.SimpleDateFormat;

public interface IDrugRepositories {
    boolean createDrug(Drug Drug);
    Drug getDrug(int id);
    Drug getDrugByName(String name);
    List<Drug> getAllDrugs();
    boolean deleteDrug(Drug Drug);
    List<Drug> getDrugByDestination(String cur);
    List<Drug> getDrugByTimeToUse(int cur);
}
