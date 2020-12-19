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
import Entities.AnnonceProd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emna
 */
public class ServiceAnnonceProd {
    
    
    
    public ArrayList<AnnonceProd> parseListTaskJson(String json) {

        ArrayList<AnnonceProd> listProds = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tabs = j.parseJSON(new CharArrayReader(json.toCharArray()));
              List<Map<String, Object>> list = (List<Map<String, Object>>) tabs.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                AnnonceProd e = new AnnonceProd();

                float id = Float.parseFloat(obj.get("idProd").toString());

                e.setId_prod((int) id);
                e.setNom_prod(obj.get("nomProd").toString());
                e.setDescription(obj.get("description").toString());
                 float prix = Float.parseFloat(obj.get("prix").toString());
                 e.setPrix((int) prix);
                 float stock = Float.parseFloat(obj.get("stock").toString());
                 e.setStock((int) stock);
                  e.setImage(obj.get("image").toString());
                  System.out.println(e);
                
               listProds.add(e);

            }

        } catch (IOException ex) {
        }
        
       
        System.out.println( listProds);
        return  listProds;

    }
    ArrayList<AnnonceProd> listProd = new ArrayList<>();
    public ArrayList<AnnonceProd> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/ecommerce/allp");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAnnonceProd ser = new ServiceAnnonceProd();
                listProd= ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProd;
    }
     
    
}
