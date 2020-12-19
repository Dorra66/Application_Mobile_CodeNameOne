/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ASUS
 */
public class Event {
    int idevent;
    String nomevent;
    String categorieevent;
    int nbrplacedispo;
    String dateevent;
    String heureevent;
    String affiche;

    public Event(int idevent, String nomevent, String categorieevent, int nbrplacedispo, String dateevent, String heureevent, String affiche) {
        this.idevent = idevent;
        this.nomevent = nomevent;
        this.categorieevent = categorieevent;
        this.nbrplacedispo = nbrplacedispo;
        this.dateevent = dateevent;
        this.heureevent = heureevent;
        this.affiche = affiche;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public String getCategorieevent() {
        return categorieevent;
    }

    public void setCategorieevent(String categorieevent) {
        this.categorieevent = categorieevent;
    }

    public int getNbrplacedispo() {
        return nbrplacedispo;
    }

    public void setNbrplacedispo(int nbrplacedispo) {
        this.nbrplacedispo = nbrplacedispo;
    }

    public String getDateevent() {
        return dateevent;
    }

    public void setDateevent(String dateevent) {
        this.dateevent = dateevent;
    }

    public String getHeureevent() {
        return heureevent;
    }

    public void setHeureevent(String heureevent) {
        this.heureevent = heureevent;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    @Override
    public String toString() {
        return "Event{" + "idevent=" + idevent + ", nomevent=" + nomevent + ", categorieevent=" + categorieevent + ", nbrplacedispo=" + nbrplacedispo + ", dateevent=" + dateevent + ", heureevent=" + heureevent + ", affiche=" + affiche + '}';
    }

    public Event() {
    }
    
    
    
}
