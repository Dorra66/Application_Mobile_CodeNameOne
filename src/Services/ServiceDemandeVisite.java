/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.demandeVisite;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import GUI.Authentification;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fares
 */
public class ServiceDemandeVisite {
    
    public void sendVR(demandeVisite dv) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date d1 = new Date();
//        String date = dateFormat.format(d1);
        //**NB:source & nomResp = get user connecté**
        String Url = "http://localhost/CiteCulture/web/app_dev.php/museum/sendVisitRequestMobile?source="+Authentification.PERSONNECONNECTEE.getNom()+" "+Authentification.PERSONNECONNECTEE.getPrenom()+"&nomOganism="+dv.getNomOrganismeD()+"&nomResp="+Authentification.PERSONNECONNECTEE.getNom()+" "+Authentification.PERSONNECONNECTEE.getPrenom()+"&numTel="+dv.getNumTelD()+"&mail="+dv.getMailD()+"&addPostal="+dv.getAddPostaleD()+"&dateVisit="+dv.getDateVisiteD().toString()+"&hourVisit="+dv.getHeureVisiteD()+"&nbreVisitors="+dv.getNbreVisiteursD()+"&etat=In progress";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager

    }
    
    
    public ArrayList<demandeVisite> parseListdemandeVisiteJson(String json) {

        ArrayList<demandeVisite> ListDV = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root"); //root est le clé de retour Json

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                demandeVisite dv = new demandeVisite();

                float id = Float.parseFloat(obj.get("iddv").toString());
                dv.setIdDV((int) id);
                dv.setSource(obj.get("source").toString());
                dv.setNomOrganismeD(obj.get("nomorganismed").toString());
                dv.setNomResponsableD(obj.get("nomresponsabled").toString());
                float telephone = Float.parseFloat(obj.get("numteld").toString());
                dv.setNumTelD((int) telephone);
                dv.setMailD(obj.get("maild").toString());
                dv.setAddPostaleD(obj.get("addpostaled").toString());
//                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(obj.get("datevisited").toString());
//                dv.setDateVisiteD((Date) obj.get("datevisited"));
                dv.setDateVisiteD(new Date(((Double) ((Map<String, Object>) obj.get("datevisited")).get("timestamp")).longValue()* 1000));
                dv.setHeureVisiteD(obj.get("heurevisited").toString());
                float NBV = Float.parseFloat(obj.get("nbrevisiteursd").toString());
                dv.setNbreVisiteursD((int) NBV);
                dv.setEtatDV(obj.get("etatdv").toString());
                ListDV.add(dv);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(ListDV);
        return ListDV;

    }
    
    ArrayList<demandeVisite> ListDV = new ArrayList<>();
    
    public ArrayList<demandeVisite> showMyVR(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/museum/showMyVisitRequestsMobile/"+Authentification.PERSONNECONNECTEE.getNom()+" "+Authentification.PERSONNECONNECTEE.getPrenom());  // +get nom de user connecté
        con.addResponseListener((NetworkEvent evt) -> {
            ServiceDemandeVisite ser = new ServiceDemandeVisite();
            ListDV = ser.parseListdemandeVisiteJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListDV;
    }
    
}
