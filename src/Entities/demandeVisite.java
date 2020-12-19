/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author fares
 */
public class demandeVisite {
    private int idDV;
    private String Source;
    private String nomOrganismeD;
    private String nomResponsableD;
    private int numTelD;
    private String mailD;
    private String addPostaleD;
    private Date dateVisiteD;
    private String heureVisiteD;
    private int nbreVisiteursD;
    private String etatDV;

    public demandeVisite() {
    }

    public demandeVisite(String Source, String nomOrganismeD, String nomResponsableD, int numTelD, String mailD, String addPostaleD, Date dateVisiteD, String heureVisiteD, int nbreVisiteursD, String etatDV) {
        this.Source = Source;
        this.nomOrganismeD = nomOrganismeD;
        this.nomResponsableD = nomResponsableD;
        this.numTelD = numTelD;
        this.mailD = mailD;
        this.addPostaleD = addPostaleD;
        this.dateVisiteD = dateVisiteD;
        this.heureVisiteD = heureVisiteD;
        this.nbreVisiteursD = nbreVisiteursD;
        this.etatDV = etatDV;
    }

    
    public demandeVisite(int idDV, String Source, String nomOrganismeD, String nomResponsableD, int numTelD, String mailD, String addPostaleD, Date dateVisiteD, String heureVisiteD, int nbreVisiteursD, String etatDV) {
        this.idDV = idDV;
        this.Source = Source;
        this.nomOrganismeD = nomOrganismeD;
        this.nomResponsableD = nomResponsableD;
        this.numTelD = numTelD;
        this.mailD = mailD;
        this.addPostaleD = addPostaleD;
        this.dateVisiteD = dateVisiteD;
        this.heureVisiteD = heureVisiteD;
        this.nbreVisiteursD = nbreVisiteursD;
        this.etatDV = etatDV;
    }

    
    public demandeVisite(int idDV, String nomOrganismeD, String nomResponsableD, int numTelD, String mailD, String addPostaleD, Date dateVisiteD, String heureVisiteD, int nbreVisiteursD, String etatDV) {
        this.idDV = idDV;
        this.nomOrganismeD = nomOrganismeD;
        this.nomResponsableD = nomResponsableD;
        this.numTelD = numTelD;
        this.mailD = mailD;
        this.addPostaleD = addPostaleD;
        this.dateVisiteD = dateVisiteD;
        this.heureVisiteD = heureVisiteD;
        this.nbreVisiteursD = nbreVisiteursD;
        this.etatDV = etatDV;
    }

    public demandeVisite(String nomOrganismeD, String nomResponsableD, int numTelD, String mailD, String addPostaleD, Date dateVisiteD, String heureVisiteD, int nbreVisiteursD, String etatDV) {
        this.nomOrganismeD = nomOrganismeD;
        this.nomResponsableD = nomResponsableD;
        this.numTelD = numTelD;
        this.mailD = mailD;
        this.addPostaleD = addPostaleD;
        this.dateVisiteD = dateVisiteD;
        this.heureVisiteD = heureVisiteD;
        this.nbreVisiteursD = nbreVisiteursD;
        this.etatDV = etatDV;
    }

    
    
    public demandeVisite(String nomOrganismeD, String nomResponsableD, int numTelD, String mailD, String addPostaleD, Date dateVisiteD, String heureVisiteD, int nbreVisiteursD) {
        this.nomOrganismeD = nomOrganismeD;
        this.nomResponsableD = nomResponsableD;
        this.numTelD = numTelD;
        this.mailD = mailD;
        this.addPostaleD = addPostaleD;
        this.dateVisiteD = dateVisiteD;
        this.heureVisiteD = heureVisiteD;
        this.nbreVisiteursD = nbreVisiteursD;
    }

    public demandeVisite(int idDV, String etatDV) {
        this.idDV = idDV;
        this.etatDV = etatDV;
    }

    
    public int getIdDV() {
        return idDV;
    }

    public void setIdDV(int idDV) {
        this.idDV = idDV;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }
    
    public String getNomOrganismeD() {
        return nomOrganismeD;
    }

    public void setNomOrganismeD(String nomOrganismeD) {
        this.nomOrganismeD = nomOrganismeD;
    }

    public String getNomResponsableD() {
        return nomResponsableD;
    }

    public void setNomResponsableD(String nomResponsableD) {
        this.nomResponsableD = nomResponsableD;
    }

    public int getNumTelD() {
        return numTelD;
    }

    public void setNumTelD(int numTelD) {
        this.numTelD = numTelD;
    }

    public String getMailD() {
        return mailD;
    }

    public void setMailD(String mailD) {
        this.mailD = mailD;
    }

    public String getAddPostaleD() {
        return addPostaleD;
    }

    public void setAddPostaleD(String addPostaleD) {
        this.addPostaleD = addPostaleD;
    }

    public Date getDateVisiteD() {
        return dateVisiteD;
    }

    public void setDateVisiteD(Date dateVisiteD) {
        this.dateVisiteD = dateVisiteD;
    }

    public String getHeureVisiteD() {
        return heureVisiteD;
    }

    public void setHeureVisiteD(String heureVisiteD) {
        this.heureVisiteD = heureVisiteD;
    }

    public int getNbreVisiteursD() {
        return nbreVisiteursD;
    }

    public void setNbreVisiteursD(int nbreVisiteursD) {
        this.nbreVisiteursD = nbreVisiteursD;
    }

    public String getEtatDV() {
        return etatDV;
    }

    public void setEtatDV(String etatDV) {
        this.etatDV = etatDV;
    }

    @Override
    public String toString() {
        return "demandeVisite{" + "idDV=" + idDV + ", nomOrganismeD=" + nomOrganismeD + ", nomResponsableD=" + nomResponsableD + ", numTelD=" + numTelD + ", mailD=" + mailD + ", addPostaleD=" + addPostaleD + ", dateVisiteD=" + dateVisiteD + ", heureVisiteD=" + heureVisiteD + ", nbreVisiteursD=" + nbreVisiteursD + ", etatDV=" + etatDV + '}';
    }

    
    

    
}
