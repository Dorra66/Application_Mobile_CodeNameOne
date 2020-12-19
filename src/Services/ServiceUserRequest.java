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
import Entities.UserRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceUserRequest {
    
    public void addUserRequest(UserRequest req) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/CiteCulture/web/app_dev.php/library/newUserRequest?" + "&memberid=" + req.getMemberId() + "&bookid=" + req.getBookId() + "&booktitle=" + req.getBookTitle()
                + "&membername=" + req.getMemberName() + "&memberlastname=" + req.getMemberLastName() + "&memberemail=" + req.getMemberMail() + "&membermobile=" + req.getMemberMobile()
                + "&issuedate=" + req.getIssueDate() + "&issueperiod=" + req.getIssuePeriod();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println("addUserRequest(service) : Success");
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
         
          public ArrayList<UserRequest> parseListTaskJson(String json) {

        ArrayList<UserRequest> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            
                //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                UserRequest userrequest = new UserRequest();   
                
                float requestid = Float.parseFloat(obj.get("idrequest").toString());
                float memberid = Float.parseFloat(obj.get("weakmemberid").toString());
                float membermobile = Float.parseFloat(obj.get("membermobile").toString());
                float issueperiod = Float.parseFloat(obj.get("issueperiod").toString());
                userrequest.setIdRequest((int) requestid);
                userrequest.setMemberId((int) memberid);
                userrequest.setBookTitle(obj.get("booktitle").toString());
                userrequest.setMemberName(obj.get("membername").toString());
                userrequest.setMemberLastName(obj.get("memberlastname").toString());
                userrequest.setMemberMobile((int) membermobile);
                userrequest.setMemberMail(obj.get("memberemail").toString());
                userrequest.setIssuePeriod((int) issueperiod);
                userrequest.setIssueDate(obj.get("issuedate").toString());
                userrequest.setRequestState(obj.get("requeststate").toString());
                listTasks.add(userrequest);
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

    ArrayList<UserRequest> listTasks = new ArrayList<>();
    
    public ArrayList<UserRequest> getList(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/library/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceUserRequest ser = new ServiceUserRequest();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
      public void deleteUserRequest(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/CiteCulture/web/app_dev.php/library/deleteuserrequest?"+"&idrequest="+id;
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println("test url1");
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
        System.out.println("test url2");
    }
}
