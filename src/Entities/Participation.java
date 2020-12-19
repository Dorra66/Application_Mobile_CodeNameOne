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
public class Participation {
    private int IdParticipation;
    private Event IdEvent;
    private User IdUser;

    public Participation(int IdParticipation, Event IdEvent, User IdUser) {
        this.IdParticipation = IdParticipation;
        this.IdEvent = IdEvent;
        this.IdUser = IdUser;
    }

    public Participation() {
    }

    public int getIdParticipation() {
        return IdParticipation;
    }

    public void setIdParticipation(int IdParticipation) {
        this.IdParticipation = IdParticipation;
    }

    public Event getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(Event IdEvent) {
        this.IdEvent = IdEvent;
    }

    public User getIdUser() {
        return IdUser;
    }

    public void setIdUser(User IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "Participation{" + "IdParticipation=" + IdParticipation + ", IdEvent=" + IdEvent + ", IdUser=" + IdUser + '}';
    }

    
    
    
}
