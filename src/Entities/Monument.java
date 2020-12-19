/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author WSI
 */
public class Monument {
    private int idM;
    private String nomM;
    private String descriptionM;
    private String imageM;

    public Monument() {
    }

    public Monument(int idM, String nomM, String descriptionM, String imageM) {
        this.idM = idM;
        this.nomM = nomM;
        this.descriptionM = descriptionM;
        this.imageM = imageM;
    }

    public Monument(String nomM, String descriptionM, String imageM) {
        this.nomM = nomM;
        this.descriptionM = descriptionM;
        this.imageM = imageM;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getDescriptionM() {
        return descriptionM;
    }

    public void setDescriptionM(String descriptionM) {
        this.descriptionM = descriptionM;
    }

    public String getImageM() {
        return imageM;
    }

    public void setImageM(String imageM) {
        this.imageM = imageM;
    }

    @Override
    public String toString() {
        return "Monument{" + "idM=" + idM + ", nomM=" + nomM + ", descriptionM=" + descriptionM + ", imageM=" + imageM + '}';
    }
 
    
}

   