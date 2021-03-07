package com.company.entities;
import java.text.SimpleDateFormat;

public class Drug{
    private int id;
    private String name;
    private int price;
    private String expirationDate;
    private String manufacturer;
    private String destination;
    private int timeToUse;

    public Drug(){

    }
    public Drug(String name, int price, String expirationDate, String manufacturer, String destination, int timeToUse){
        setName(name);
        setPrice(price);
        setExpirationDate(expirationDate);
        setManufacturer(manufacturer);
        setDestination(destination);
        setTimeToUse(timeToUse);
    }
    public Drug(int id, String name, int price, String expirationDate, String manufacturer, String destination, int timeToUse){
        setId(id);
        setName(name);
        setPrice(price);
        setExpirationDate(expirationDate);
        setManufacturer(manufacturer);
        setDestination(destination);
        setTimeToUse(timeToUse);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int Price) {
        this.price = price;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public int getTimeToUse() {
        return timeToUse;
    }

    public void setTimeToUse(int timeToUse) {
        this.timeToUse = timeToUse;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", Drug_name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", manufacturer=" + manufacturer + '\'' +
                ", destination=" + destination + '\'' +
                ", timeToUse=" + timeToUse +
                '}' + "\n";
    }
}