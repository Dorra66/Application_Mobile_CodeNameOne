/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ReclamationM {
    int idRM;
    String Idsource;
    String roleSource;
    String objetReclamation;
    String descriptionReclamation;
    String dateReclamation;
    String statusReclamation;
    String reponseReclamation;
    String destinationReclamation;

    public ReclamationM() {
    }

    public ReclamationM(int idRM, String Idsource, String roleSource, String objetReclamation, String descriptionReclamation, String dateReclamation, String statusReclamation, String reponseReclamation, String destinationReclamation) {
        this.idRM = idRM;
        this.Idsource = Idsource;
        this.roleSource = roleSource;
        this.objetReclamation = objetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.dateReclamation = dateReclamation;
        this.statusReclamation = statusReclamation;
        this.reponseReclamation = reponseReclamation;
        this.destinationReclamation = destinationReclamation;
    }

    public int getIdRM() {
        return idRM;
    }

    public void setIdRM(int idRM) {
        this.idRM = idRM;
    }

    public String getIdsource() {
        return Idsource;
    }

    public void setIdsource(String Idsource) {
        this.Idsource = Idsource;
    }

    public String getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(String roleSource) {
        this.roleSource = roleSource;
    }

    public String getObjetReclamation() {
        return objetReclamation;
    }

    public void setObjetReclamation(String objetReclamation) {
        this.objetReclamation = objetReclamation;
    }

    public String getDescriptionReclamation() {
        return descriptionReclamation;
    }

    public void setDescriptionReclamation(String descriptionReclamation) {
        this.descriptionReclamation = descriptionReclamation;
    }

    public String getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(String dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getStatusReclamation() {
        return statusReclamation;
    }

    public void setStatusReclamation(String statusReclamation) {
        this.statusReclamation = statusReclamation;
    }

    public String getReponseReclamation() {
        return reponseReclamation;
    }

    public void setReponseReclamation(String reponseReclamation) {
        this.reponseReclamation = reponseReclamation;
    }

    public String getDestinationReclamation() {
        return destinationReclamation;
    }

    public void setDestinationReclamation(String destinationReclamation) {
        this.destinationReclamation = destinationReclamation;
    }

    @Override
    public String toString() {
        return "ReclamationM{" + "idRM=" + idRM + ", Idsource=" + Idsource + ", roleSource=" + roleSource + ", objetReclamation=" + objetReclamation + ", descriptionReclamation=" + descriptionReclamation + ", dateReclamation=" + dateReclamation + ", statusReclamation=" + statusReclamation + ", reponseReclamation=" + reponseReclamation + ", destinationReclamation=" + destinationReclamation + '}';
    }

}