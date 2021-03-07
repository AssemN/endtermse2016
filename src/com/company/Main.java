package com.company;

import com.company.controllers.DrugController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.entities.Drug;
import com.company.repositories.DrugRepositories;
import com.company.repositories.interfaces.IDrugRepositories;

import java.util.List;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IDrugRepositories repo = new DrugRepositories(db);
        DrugController controller = new DrugController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}

