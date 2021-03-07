package com.company;

import com.company.controllers.DrugController;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class MyApplication {
    private final DrugController controller;
    private final Scanner scanner;

    public MyApplication(DrugController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        for(;;){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (1-6)");
            System.out.println("1. Show all drugs");
            System.out.println("2. Search by name");
            System.out.println("3. Search by ID");
            System.out.println("4. Add Drug to database");
            System.out.println("5. Delete Drug");
            System.out.println("6. Show drugs that fits given criteria");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (1-6)");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    getAllDrugsMenu();
                }
                else if(option == 2){
                    getDrugByNameMenu();
                }
                else if(option == 3){
                    getDrugByIdMenu();
                }
                else if(option == 4){
                    createDrugMenu();
                }
                else if(option == 5){
                    deleteDrugByIdMenu();
                }
                else if(option == 6){
                    System.out.println("1. Give criteria for illness area");
                    System.out.println("2. Give criteria for drug time to work");
                    System.out.println("Enter the option: (1-2)");
                    int option2 = scanner.nextInt();
                    scanner.nextLine();
                    if(option2 == 1){
                        getDrugByDestinationMenu();
                    }
                    else{
                        getDrugByTimeToUseMenu();
                    }
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("\n\n");
        }
    }
    public void getAllDrugsMenu(){
        String response = controller.getAllDrugs();
        System.out.println(response);
    }

    public void getDrugByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getDrug(id);
        System.out.println(response);
        scanner.nextLine();
    }

    public void getDrugByNameMenu(){
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        String response = controller.getDrugByName(name);
        System.out.println(response);
    }

    public void createDrugMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter Drug name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Please enter price");
        int price = scanner.nextInt();
        System.out.println("Please enter Drug expiration date");
        scanner.nextLine();
        String expiration = scanner.nextLine();
        System.out.println("Please enter Drug manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Please enter Drug destination");
        String destination = scanner.nextLine();
        System.out.println("Please enter Drug timeToUse:");
        System.out.println("1 if headache ");
        System.out.println("2 if stomach illness ");
        System.out.println("3 if heart illness ");
        int illness = scanner.nextInt();
        String response = controller.createDrug(id, name, price, expiration, manufacturer, destination, illness);
        System.out.println(response);
        scanner.nextLine();
    }

    public void deleteDrugByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        String response = controller.deleteDrug(id);
        System.out.println(response);
    }

    public void getDrugByDestinationMenu(){
        System.out.println("Please enter destination(enter the word itself)");
        System.out.println("1. Allergia");
        System.out.println("2. Conjunctivite");
        System.out.println("3. Headache");
        System.out.println("4. Mononucleosis");
        System.out.println("5. Stomach Aches");
        String cur = scanner.nextLine();
        String response = controller.getDrugByDestination(cur);
        System.out.println(response);
    }

    public void getDrugByTimeToUseMenu(){
        System.out.println("Please enter needed time(in minutes)");
        int cur = scanner.nextInt();
        scanner.nextLine();
        String response = controller.getDrugByTimeToUse(cur);
        System.out.println(response);
    }

}
