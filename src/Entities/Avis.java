/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.User;

/**
 *
 * @author ASUS
 */
public class Avis {
    private int idavis;
    private Event idevent;
    private User iduser;
    private String descriptionavis;

    public Avis() {
        
    }

    public Avis(int idavis, Event idevent, User iduser, String descriptionavis) {
        this.idavis = idavis;
        this.idevent = idevent;
        this.iduser = iduser;
        this.descriptionavis = descriptionavis;
    }

    public int getIdavis() {
        return idavis;
    }

    public void setIdavis(int idavis) {
        this.idavis = idavis;
    }

    public Event getIdevent() {
        return idevent;
    }

    public void setIdevent(Event idevent) {
        this.idevent = idevent;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public String getDescriptionavis() {
        return descriptionavis;
    }

    public void setDescriptionavis(String descriptionavis) {
        this.descriptionavis = descriptionavis;
    }

    @Override
    public String toString() {
        return "Avis{" + "idavis=" + idavis + ", idevent=" + idevent + ", iduser=" + iduser + ", descriptionavis=" + descriptionavis + '}';
    }

   
    
}
