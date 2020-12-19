/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.db.Database;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.events.ActionListener;
import Entities.AnnonceProd;
import Entities.Panier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Entities.PanierRempli;
import Entities.Total;
import Entities.User;

/**
 *
 * @author emna
 */
public class ServicePanier {
    
 
     public void ajout(Panier p ) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion pour se connecter au serveur web
        String Url = "http://localhost/CiteCulture/web/app_dev.php/ecommerce/addproduitsper/" +p.getProduit();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
  
  
 public ArrayList<PanierRempli> parseListTaskJson(String json) {

        ArrayList<PanierRempli> listTasks = new ArrayList<>();

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
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                PanierRempli e = new PanierRempli();
                AnnonceProd p=new AnnonceProd();
                User u=new User();

                float id = Float.parseFloat(obj.get("id").toString());
               
                e.setId_pn((int) id);
               
                e.setProduit(obj.get("produit").toString());
               e.setUser(obj.get("user").toString());
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
    
    
    ArrayList<PanierRempli> listTasks = new ArrayList<>();
    
    public ArrayList<PanierRempli> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/ecommerce/monpanierper");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePanier ser = new ServicePanier();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    
    
    
    
    
    
    
    
   
}

    

 
       
    
 
    