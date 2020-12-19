/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import Entities.AnnonceProd;
import Entities.PanierRempli;
import Entities.User;
import Services.ServicePanier;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author emna
 */
public class PanierAddForm {
    Form panierForm = new Form("My basket", BoxLayout.y());
    
       EncodedImage enc;
     public  PanierAddForm(){
         
    
        /*ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion pour se connecter au serveur web
        String Url = "http://localhost:8089/emna/CiteCulture/web/app_dev.php/ecommerce/monpanier";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            Container list=new Container(BoxLayout.y());  
              list.setScrollableX(true); 
    
            MultiButton mb=new MultiButton("Products list");
               mb.setTextLine2(str);
              
               
                panierForm.add(list);
               
                        
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
     

     */
            PanierRempli p=new  PanierRempli();
        ServicePanier sp=new ServicePanier();
                               
                Label nomprodLabel = new Label();
                 nomprodLabel.setText("Products Informations:"+String.valueOf(sp.getList2().get(p.getId_pn()).getProduit().toString()));
                
               
                Label NomUserLabel = new Label();
                NomUserLabel.setText("Client informations"+String.valueOf(sp.getList2().get(p.getId_pn()).getUser().toString()));
                Container c =new Container();
                c.add(nomprodLabel);
                // c.add(pricelabel );
                 c.add(NomUserLabel);
                  Label totalLabel = new Label();
                   ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/ecommerce/montotalper");  
        con.addResponseListener((e) -> {
               
              String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);
            totalLabel.setText("Total :"+str+"DT");
              
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
                  c.add(totalLabel);
                 panierForm.add(c);
                 panierForm.show();
      
     
               
        
     
     
      panierForm.getToolbar().addCommandToRightBar("back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           MenuForm  mf =new MenuForm();
          mf.getFjdida().show();
            }
        }); 
     
     
}

    public Form getPanierForm() {
        return panierForm;
    }
    
                

            
              
    
     
}