/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Entities.Participation;
import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import GUI.Authentification;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public class ParticipationService {
    
 

    
    public ArrayList<Event> parsePartJson(String json) {
        
        ArrayList<Event> listpart = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> evenements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
            for (Map<String, Object> obj : list) {
                Event e = new Event();
                EventService es =new EventService();
                
        float id = Float.parseFloat(obj.get("idevent").toString());
                e.setIdevent((int) id);
              // float id = Float.parseFloat(obj.get("idevent").toString());
                //e.setIdevent((int) id);
                e.setNomevent(obj.get("nomevent").toString());
                e.setCategorieevent(obj.get("categorieevent").toString());
                float nbrplace = Float.parseFloat(obj.get("nbrplacedispo").toString());
                e.setNbrplacedispo((int)nbrplace);
                e.setHeureevent(obj.get("heureevent").toString());
                e.setDateevent(es.getDateEvenement((int) id));
                e.setAffiche(obj.get("affiche").toString());
                    
                
                listpart.add(e);
                
            }
        } catch (IOException ex) {
        }
        return listpart;
    
    }

   public void ajouterPartEvenement(int idevent,int iduser) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteCulture/web/app_dev.php/mobile/ajoutParticip/" + idevent + "/" + iduser ;// création de l'URL
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
   
   public void deletePartEvenement(int idevent,int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/CiteCulture/web/app_dev.php/mobile/UserDeletePart?idevent=" + idevent+ "&id=" +id;// création de l'URL
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }


   
   ArrayList<Event> listPart = new ArrayList();
   public ArrayList<Event> getListPart() {
        ConnectionRequest cnx = new ConnectionRequest();
        cnx.setUrl("http://localhost/CiteCulture/web/app_dev.php/mobile/MyParticipations/" +Authentification.PERSONNECONNECTEE.getId());
        cnx.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ParticipationService ser = new ParticipationService();
                listPart = ser.parsePartJson(new String(cnx.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cnx);
        return listPart;
    }
   
   
   
   
  /***********Parsing de  ma participation********/
   public Participation parseParticipationJson(String json) {

        Participation participation = null;
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> Aviss = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Participation a = new Participation();
            if (!Aviss.isEmpty()) {
                float valeur = Float.parseFloat(Aviss.get("valeur").toString());
                a.setIdParticipation((int) valeur);
                participation = a;
            }
        } catch (IOException ex) {
        }
        return participation;
    }
   
   Participation Part = new Participation();

    public Participation getMonPart(int idevent, int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/mobile/getMyPart?idUser=" + idevent + "&idEvenement=" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ParticipationService ser = new ParticipationService();
                Part = ser.parseParticipationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Part;
    }


}
