/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;


/**
 *
 * @author emna
 */
public class PanierRempli {
     private int id_pn;
    private String produit;
    private String user;

    public PanierRempli() {
    }

    public int getId_pn() {
        return id_pn;
    }

    public String getProduit() {
        return produit;
    }

    public String getUser() {
        return user;
    }
    

    public void setId_pn(int id_pn) {
        this.id_pn = id_pn;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
}
    
    
    
    
    
