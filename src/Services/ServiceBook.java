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
import Entities.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceBook {
    
    
      public ArrayList<Book> parseListTaskJson(String json) {

        ArrayList<Book> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            
                //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Book book = new Book();  
               // float bookquantity = Float.parseFloat(obj.get("bookquantity").toString());
                book.setBookTitle(obj.get("booktitle").toString());
                book.setBookAuthor(obj.get("bookauthor").toString());
               // book.setBookCategory(obj.get("bookcategory").toString());
                book.setBookImage(obj.get("bookimage").toString());
             //   book.setBookQuantity((int) bookquantity);
                listTasks.add(book);
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

    ArrayList<Book> listTasks = new ArrayList<>();
    
    public ArrayList<Book> getList(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/library/allBooks");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceBook ser = new ServiceBook();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
}
