package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Drug;
import com.company.repositories.interfaces.IDrugRepositories;

import java.sql.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;

public class DrugRepositories implements IDrugRepositories {
    private final IDB db;

    public DrugRepositories(IDB db){this.db = db;}

    @Override
    public boolean createDrug(Drug drug) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Drug(id, Drug_name, price, expirationdate, manufacturer, destination, timeToUse) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, drug.getId());
            st.setString(2, drug.getName());
            st.setInt(3, drug.getPrice());
            st.setString(4, drug.getExpirationDate());
            st.setString(5, drug.getManufacturer());
            st.setString(6, drug.getDestination());
            st.setInt(7, drug.getTimeToUse());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Drug getDrug(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  id, Drug_name, price, expirationdate, manufacturer, destination, timeToUse FROM Drug WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Drug drug = new Drug(rs.getInt("id"),
                        rs.getString("Drug_name"),
                        rs.getInt("price"),
                        rs.getString("expirationdate"),
                        rs.getString("manufacturer"),
                        rs.getString("destination"),
                        rs.getInt("timeToUse"));
                return drug;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Drug getDrugByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  * FROM Drug;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Drug drug = new Drug(rs.getInt("id"),
                        rs.getString("Drug_name"),
                        rs.getInt("price"),
                        rs.getString("expirationdate"),
                        rs.getString("manufacturer"),
                        rs.getString("destination"),
                        rs.getInt("timeToUse"));
                if(drug.getName().equals(name)){
                    return drug;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drug> getAllDrugs() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Drug;";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Drug> drugs = new LinkedList<>();
            while(rs.next()){
                Drug drug = new Drug(rs.getInt("id"),
                        rs.getString("Drug_name"),
                        rs.getInt("price"),
                        rs.getString("expirationdate"),
                        rs.getString("manufacturer"),
                        rs.getString("destination"),
                        rs.getInt("timeToUse"));
                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteDrug(Drug drug){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE from Drug WHERE id=" + drug.getId() + ";";
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Drug> getDrugByDestination(String cur){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Drug";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Drug> drugs = new LinkedList<>();
            while(rs.next()){
                Drug drug = new Drug(rs.getInt("id"),
                        rs.getString("Drug_name"),
                        rs.getInt("price"),
                        rs.getString("expirationdate"),
                        rs.getString("manufacturer"),
                        rs.getString("destination"),
                        rs.getInt("timeToUse"));
                String res = drug.getDestination();
                if(cur.equals(res)){
                    drugs.add(drug);
                }
            }
            return drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Drug> getDrugByTimeToUse(int cur) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Drug";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Drug> Drugs = new LinkedList<>();
            while(rs.next()){
                Drug drug = new Drug(rs.getInt("id"),
                        rs.getString("Drug_name"),
                        rs.getInt("price"),
                        rs.getString("expirationdate"),
                        rs.getString("manufacturer"),
                        rs.getString("destination"),
                        rs.getInt("timeToUse"));
                int res = drug.getTimeToUse();
                if(cur >= res){
                    Drugs.add(drug);
                }
            }
            return Drugs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
