/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Avis;
import Entities.Event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import GUI.Authentification;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class AvisService {
    
    public ArrayList<Avis> parseListTaskJson(String json) {

        ArrayList<Avis> listTasks = new ArrayList<>();

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
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root"); // root pour le clé du retour JSON

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
               Avis e = new Avis();

                float id = Float.parseFloat(obj.get("idavis").toString());
                float idevent = Float.parseFloat(obj.get("idevent").toString());
                
                

                //e.setIdAvis((int) id);
                //e.setIdEvent((int) idevent);
                
              e.setDescriptionavis(obj.get("descriptionavis").toString());
                

                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    ArrayList<Avis> listTasks = new ArrayList<>();
    
    public ArrayList<Avis> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/event/AfficheAvisMob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AvisService evs = new AvisService();
                listTasks = evs.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    /********ajout avis*********/
    public void ajouterAvisEvenement(int idevent, int iduser, String commentaire) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteCulture/web/app_dev.php/mobile/ajouterCommentaire?idevent=" + idevent + "&iduser=" + iduser + "&commentaire=" + commentaire;// création de l'URL
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

/********parsing des avis**********/
    public ArrayList<Avis> parseListAvisJson(String json) {
        
        ArrayList<Avis> listAvis = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> evenements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
            for (Map<String, Object> obj : list) {
                Avis av = new Avis();
                float id = Float.parseFloat(obj.get("idavis").toString());
                av.setIdavis((int) id);
                av.setDescriptionavis(obj.get("descriptionavis").toString());
                //System.out.println(e);
                listAvis.add(av);
            }
        } catch (IOException ex) {
        }
        return listAvis;
    
    }
    
    
    /************get liste feeds********/
    ArrayList<Avis> listFeeds = new ArrayList();
    public ArrayList<Avis> getListAvis() {
        ConnectionRequest cnx = new ConnectionRequest();
        cnx.setUrl("http://localhost/CiteCulture/web/app_dev.php/mobile/myFeeds?iduser="+Authentification.PERSONNECONNECTEE.getId());
        cnx.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AvisService ser = new AvisService();
                listFeeds = ser.parseListAvisJson(new String(cnx.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cnx);
        return listFeeds;
    }
    
}
