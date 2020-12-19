/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class EventService {
    
    public ArrayList<Event> parseListEvenementsJson(String json) {
        
        ArrayList<Event> listEvenements = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> evenements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
            for (Map<String, Object> obj : list) {
                Event e = new Event();
                float id = Float.parseFloat(obj.get("idevent").toString());
                e.setIdevent((int) id);
                e.setNomevent(obj.get("nomevent").toString());
                e.setCategorieevent(obj.get("categorieevent").toString());
                float nbrplace = Float.parseFloat(obj.get("nbrplacedispo").toString());
                e.setNbrplacedispo((int)nbrplace);
                e.setHeureevent(obj.get("heureevent").toString());
                e.setDateevent(getDateEvenement((int) id));
                e.setAffiche(obj.get("affiche").toString());
                //System.out.println(e);
                listEvenements.add(e);
            }
        } catch (IOException ex) {
        }
        return listEvenements;
    
    }
    
    

    ArrayList<Event> listEvenements = new ArrayList();
    String date = new String();

    public String getDateEvenement(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/mobile/getDateEvent/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                date = new String(con.getResponseData());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return date;
    }
    
    public ArrayList<Event> getListEvenements() {
        ConnectionRequest cnx = new ConnectionRequest();
        cnx.setUrl("http://localhost/CiteCulture/web/app_dev.php/mobile/afficheEvent");
        cnx.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EventService ser = new EventService();
                listEvenements = ser.parseListEvenementsJson(new String(cnx.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cnx);
        return listEvenements;
    }
}

    

