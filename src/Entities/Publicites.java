/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author dorra
 */
public class Publicites {
   private int id;
   private String titre;
   private String description;
   private String imag;

    public Publicites() {
    }

    public Publicites(int id, String titre, String description, String imag) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.imag = imag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    @Override
    public int hashCode() {
        int hash = id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicites other = (Publicites) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imag, other.imag)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicites{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", imag=" + imag + '}';
    }
    public String toStringi() {
        return "" + id ;
    }
   
    
}
