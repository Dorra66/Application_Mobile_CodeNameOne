/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author emna
 */
public class Panier {
    private int id;
    private int user;
    private int produit;

    public Panier() {
    }

    public Panier(int user, int produit) {
        this.user = user;
        this.produit = produit;
    }
    

    public Panier(int id, int user, int produit) {
        this.id = id;
        this.user = user;
        this.produit = produit;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getProduit() {
        return produit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", user=" + user + ", produit=" + produit + '}';
    }
    
    
}
