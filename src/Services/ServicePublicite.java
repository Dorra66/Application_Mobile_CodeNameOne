/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entities.Publicites;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServicePublicite {

    public void ajoutPub(Publicites ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion pour se connecter au serveur web
        String Url = "http://localhost/CiteCulture/web/app_dev.php/actuality/publicites/add?titre=" + ta.getTitre()+"&description="+ ta.getDescription()+"&imag="+ ta.getImag();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public void suppPub(Publicites ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion pour se connecter au serveur web
        String Url = "http://localhost/CiteCulture/web/app_dev.php/actuality/publicites/" + ta.getId()+"/supp";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    ////pdf/////
     
     
     
     ///////////////////////
    public ArrayList<Publicites> parseListTaskJson(String json) {

        ArrayList<Publicites> listPubs = new ArrayList<>();

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
            Map<String, Object> pubs = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) pubs.get("root");

            //Parcourir la liste des tâches Json
             for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Publicites e = new Publicites();

                float id = Float.parseFloat(obj.get("id").toString());

                e.setId((int) id);
                e.setTitre(obj.get("titre").toString());
                e.setDescription(obj.get("description").toString());
                e.setImag(obj.get("imag").toString());
                System.out.println(e);
                
                listPubs.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listPubs);
        return listPubs;

    }
    
    
    ArrayList<Publicites> listPubs = new ArrayList<>();
    
    public ArrayList<Publicites> getList2(){      //crud  
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl( "http://localhost/CiteCulture/web/app_dev.php/actuality/publicites/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePublicite ser = new ServicePublicite();
                listPubs = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPubs;
    }
    /////////recherche//////////
    
     public ArrayList<Publicites> Recherche(String titre){        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl( "http://localhost/CiteCulture/web/app_dev.php/actuality/publicites/find/"+titre);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePublicite ser = new ServicePublicite();
                listPubs = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPubs;
    }

}
