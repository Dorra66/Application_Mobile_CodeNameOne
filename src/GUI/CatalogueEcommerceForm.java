/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;
import Entities.AnnonceProd;
import Entities.Panier;
import Services.ServiceAnnonceProd;
import Services.ServicePanier;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author emna
 */
public class CatalogueEcommerceForm {
    Form CatalogueForm;
   EncodedImage enc;
   
   Button btn;
   int id,idd;
   
   Container listt=new Container(BoxLayout.y()); 
    
    MultiButton mbb=new MultiButton();
    
    public CatalogueEcommerceForm(){
     CatalogueForm = new Form("Catalogue", new FlowLayout(Component.CENTER, Component.CENTER));
    // CatalogueForm.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeEcommerceForm  homeForm=new HomeEcommerceForm();
      //    homeForm.getHomeForm().show();
        //  });
CatalogueForm.getToolbar().addCommandToRightBar("back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           MenuForm  homeForm=new MenuForm();
           homeForm.getFjdida().showBack();
            }
        }); 


//lb = new SpanLabel("");
       // CatalogueForm.add(lb);
        ServiceAnnonceProd service=new ServiceAnnonceProd();
      ArrayList<AnnonceProd> pers=(ArrayList<AnnonceProd>) service.getList2();
        ObservableList<AnnonceProd> obs = FXCollections.observableArrayList(pers);
          
      
     Container list=new Container(BoxLayout.y());  
     list.setScrollableY(true); 
     for (int i = 0; i < obs.size() ;i++) {
            
         MultiButton mb=new MultiButton("product n°"+i);
         mb.setTextLine2(obs.get(i).toString());
         list.add(mb);
         
       Container c =new Container(BoxLayout.y());  
          btn  = new Button("Add to my basket");
           c.add(btn);
           list.add(c);
             if(mb.getTextLine1().toString().equalsIgnoreCase("product n°0")){
           btn.addActionListener((e) -> {
             Dialog.show("confirm", "product added succefully", "OK", "Cancel");
             Panier p=new Panier(5, 29);
               ServicePanier ps=new ServicePanier();
               ps.ajout(p);
             });
             }
             if(mb.getTextLine1().toString().equalsIgnoreCase("product n°1")){
           btn.addActionListener((e) -> {
               Panier p=new Panier(5, 28);
               ServicePanier ps=new ServicePanier();
               ps.ajout(p);
             Dialog.show("confirm", "product added succefully", "OK", "Cancel");
             
             });
             }
             if(mb.getTextLine1().toString().equalsIgnoreCase("product n°3")){
           btn.addActionListener((e) -> {
             
             Panier p=new Panier(5, 27);
               ServicePanier ps=new ServicePanier();
               ps.ajout(p);
               Dialog.show("confirm", "product added succefully", "OK", "Cancel");
             
             });
             }
              if(mb.getTextLine1().toString().equalsIgnoreCase("product n°4")){
           btn.addActionListener((e) -> {

             Panier p=new Panier(5, 21);
               ServicePanier ps=new ServicePanier();
               ps.ajout(p);
             Dialog.show("confirm", "product added succefully", "OK", "Cancel");
             });
             }
               if(mb.getTextLine1().toString().equalsIgnoreCase("product n°5")){
           btn.addActionListener((e) -> {
              
             Dialog.show("confirm", "insufficent sock", "OK", "Cancel");
             
             });
             }
           if(mb.getTextLine1().toString().equalsIgnoreCase("product n°6")){
           btn.addActionListener((e) -> {
            
             Panier p=new Panier(5, 20);
               ServicePanier ps=new ServicePanier();
               ps.ajout(p);
               Dialog.show("confirm", "product added succefully", "OK", "Cancel");
             });
             }
            if(mb.getTextLine1().toString().equalsIgnoreCase("product n°2")){
            btn.addActionListener((e) -> {
             Dialog.show("confirm", "insufficent sock", "OK", "Cancel");
             
             }); 
         }     
             
          mb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
        if(mb.getTextLine1().toString().equalsIgnoreCase("product n°0")){
              listt=new Container(BoxLayout.y());  
               listt.setScrollableY(true); 
              mbb=new MultiButton("Beautiful painting ==>250DT");
               try {
               enc = EncodedImage.create("/tab.png");
            } catch (IOException ex) {
              }
               mbb.setIcon(enc);
           DetaillersForm df=new DetaillersForm();
                df.getDetailleForm().add(mbb);
                df.getDetailleForm().show();
        }
       if(mb.getTextLine1().toString().equalsIgnoreCase("product n°1")){
              listt=new Container(BoxLayout.y());  
               listt.setScrollableY(true); 
              mbb=new MultiButton("pretty antique dealer ==>60DT");
               try {
               enc = EncodedImage.create("/2.jpg");
            } catch (IOException ex) {
              }
               mbb.setIcon(enc);
                 DetaillersForm df=new DetaillersForm();   
                df.getDetailleForm().add(mbb);
                df.getDetailleForm().show();
            
       }
       if(mb.getTextLine1().toString().equalsIgnoreCase("product n°2")){
              listt=new Container(BoxLayout.y());  
               listt.setScrollableY(true); 
              mbb=new MultiButton("arrangement antiquaire ==>200DT");
               try {
               enc = EncodedImage.create("/4.jpg");
            } catch (IOException ex) {
              }
               mbb.setIcon(enc);
                 DetaillersForm df=new DetaillersForm();   
                df.getDetailleForm().add(mbb);
                df.getDetailleForm().show();
            
       }
     }
             });
     }
     CatalogueForm.add(list);
      
     }


    public Form getCatalogueForm() {
        return CatalogueForm;
    }

    
    
    
}
