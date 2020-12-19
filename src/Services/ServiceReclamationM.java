/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Monument;
import Entities.ReclamationM;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
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
public class ServiceReclamationM {
    
    public void sendClaim(ReclamationM RM) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d1 = new Date();
        String date = dateFormat.format(d1);
        //**NB:idsource= get user connecté**
        String Url = "http://localhost/CiteCulture/web/app_dev.php/museum/sendClaimMobile?idsource="+Authentification.PERSONNECONNECTEE.getNom()+" "+Authentification.PERSONNECONNECTEE.getPrenom()+"&rolesource=Client"+"&objRec="+RM.getObjetReclamation()+"&descRec="+RM.getDescriptionReclamation()+"&dateRec="+date+"&stateRec=Not Seen Yet"+"&repRec=No response"+"&destRec=Admin";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager

    }
    
    public ArrayList<ReclamationM> parseListReclamationMJson(String json) {

        ArrayList<ReclamationM> ListReclamationM = new ArrayList<>();

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
                ReclamationM RM = new ReclamationM();

                float id = Float.parseFloat(obj.get("idrm").toString());

                RM.setIdRM((int) id);
                RM.setIdsource(obj.get("idsource").toString());
                RM.setRoleSource(obj.get("rolesource").toString());
                RM.setObjetReclamation(obj.get("objetreclamation").toString());
                RM.setDescriptionReclamation(obj.get("descriptionreclamation").toString());
                RM.setDateReclamation(obj.get("datereclamation").toString());
                RM.setStatusReclamation(obj.get("statutsreclamation").toString());
                RM.setReponseReclamation(obj.get("reponsereclamation").toString());
                RM.setDestinationReclamation("Admin");
                ListReclamationM.add(RM);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(ListReclamationM);
        return ListReclamationM;

    }
    
    ArrayList<ReclamationM> ListReclamationM = new ArrayList<>();
    
    public ArrayList<ReclamationM> showMyClaims(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/museum/showMyClaimsMobile/"+Authentification.PERSONNECONNECTEE.getNom()+" "+Authentification.PERSONNECONNECTEE.getPrenom());  // +get nom de user connecté
        con.addResponseListener((NetworkEvent evt) -> {
            ServiceReclamationM ser = new ServiceReclamationM();
            ListReclamationM = ser.parseListReclamationMJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListReclamationM;
    }
    
}
